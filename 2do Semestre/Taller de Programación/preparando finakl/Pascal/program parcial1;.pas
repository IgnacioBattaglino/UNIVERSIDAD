program parcial1;
type

pedido=record
    dni:longint;
    nombre,fecha:string;
    monto:real;
end;

pedido2=record
    fecha:string;
    monto:real;
end;

lista=^nodo2;
nodo2=record
    sig:lista;
    dato:pedido2;
end;

datoarbol=record
    dni:longint;
    nombre:string;
    lista:lista;
end;

arbol=^nodo;
nodo=record
    dato:datoarbol;
    hd:arbol;
    hi:arbol;
end;

procedure agregaradelante (var l:lista; p:pedido);
var nuevo:lista;
begin
    new (nuevo);
    nuevo^.dato.fecha:= p.fecha;
    nuevo^.dato.monto:= p.monto;
    if (l=nil) then begin
        l:=nuevo;
        nuevo^.sig:=nil
    end
    else
        nuevo^.sig:=l;
        l:=nuevo;
end;
    
procedure agregaralarbol (var a:arbol; p:pedido);
begin
    if (a=nil) then begin
        new (a);
        a^.dato.dni:=p.dni;
        a^.dato.nombre:=p.nombre;
        a^.hd:=nil;
        a^.hi:=nil;
        agregaradelante(a^.dato.lista,p)
    end
    else 
        if (a^.dato.dni=p.dni) then agregaradelante(a^.dato.lista,p)
    else
        if (a^.dato.dni>p.dni) then agregaralarbol (a^.hi,p)
    else 
        agregaralarbol (a^.hd,p);
end;

(*
procedure leer (var p:pedido);
begin
    writeln ('Ingrese el monto del pedido');
    readln (p.monto);
    if (p.monto<>0) then begin
        writeln ('Ingrese el dni del cliente');
        readln (p.dni);
        writeln ('Ingrese el nombre del cliente');
        readln (p.nombre);
        writeln ('Ingrese la fecha del pedido (formato: dd.mm.aa');
        readln (p.fecha);
    end;    
end;

procedure cargararbol (var a:arbol);
var 
p:pedido;
begin
    p.monto:=1;
    while (p.monto<>0) do begin
        leer (p);
        agregaralarbol (a,p);
    end;
end;
*)

procedure forzardatos(var a:arbol);
var p:pedido;
begin
    p.dni:= 46269132;
    p.nombre:= 'Nacho';
    p.fecha:= '20.10.23';
    p.monto:= 100;
    agregaralarbol (a,p);
    p.dni:= 22851780;
    p.nombre:= 'Carlos';
    p.fecha:= '20.10.23';
    p.monto:= 200;
    agregaralarbol (a,p);
    p.dni:= 21888378;
    p.nombre:= 'Cecilia';
    p.fecha:= '20.10.23';
    p.monto:= 300;
    agregaralarbol (a,p);
    p.dni:= 41670832;
    p.nombre:= 'Franco';
    p.fecha:= '20.10.23';
    p.monto:= 400;
    agregaralarbol (a,p);
    p.dni:= 46269132;
    p.nombre:= 'Nacho';
    p.fecha:= '15.09.23';
    p.monto:= 150;
    agregaralarbol (a,p);
    p.dni:= 22851780;
    p.nombre:= 'Carlos';
    p.fecha:= '20.07.22';
    p.monto:= 220;
    agregaralarbol (a,p);
    p.dni:= 21888378;
    p.nombre:= 'Cecilia';
    p.fecha:= '05.11.21';
    p.monto:= 130;
    agregaralarbol (a,p);
    p.dni:= 41670832;
    p.nombre:= 'Franco';
    p.fecha:= '20.10.23';
    p.monto:= 150;
    agregaralarbol (a,p);
    p.dni:= 46269132;
    p.nombre:= 'Nacho';
    p.fecha:= '20.10.23';
    p.monto:= 100;
    agregaralarbol (a,p);
    p.dni:= 22851780;
    p.nombre:= 'Carlos';
    p.fecha:= '20.10.23';
    p.monto:= 200;
    agregaralarbol (a,p);
    p.dni:= 21888378;
    p.nombre:= 'Cecilia';
    p.fecha:= '20.10.23';
    p.monto:= 300;
    agregaralarbol (a,p);
    p.dni:= 41670832;
    p.nombre:= 'Franco';
    p.fecha:= '20.10.23';
    p.monto:= 400;
    agregaralarbol (a,p);
    p.dni:= 46269132;
    p.nombre:= 'Nacho';
    p.fecha:= '15.09.23';
    p.monto:= 150;
    agregaralarbol (a,p);
    p.dni:= 22851780;
    p.nombre:= 'Carlos';
    p.fecha:= '20.07.22';
    p.monto:= 220;
    agregaralarbol (a,p);
    p.dni:= 21888378;
    p.nombre:= 'Cecilia';
    p.fecha:= '05.11.21';
    p.monto:= 130;
    agregaralarbol (a,p);
    p.dni:= 41670832;
    p.nombre:= 'Franco';
    p.fecha:= '20.10.23';
    p.monto:= 150;
    agregaralarbol (a,p);
end;

procedure imprimirarbol (a:arbol);
begin
    if (a<>nil) then begin
        imprimirarbol (a^.hi);
        writeln (a^.dato.dni);
        imprimirarbol (a^.hd);
    end;
end;

procedure pedidosfecha (a:arbol; fecha:string; var cant:integer);
var current:lista;
aux:boolean;
begin
    if (a<>nil) then begin
    aux:=false;
    pedidosfecha (a^.hi,fecha,cant);
        current:=a^.dato.lista;
            while (current<>nil) and (aux=false) do begin
                if (current^.dato.fecha=fecha) then begin 
                    cant:=cant+1;
                    aux:=true;
                end            
                else
                    current:=current^.sig;
            end;
        pedidosfecha (a^.hd,fecha,cant);
    end;    
end;

procedure total (a:arbol; var abon:real; var pedid:integer; dni:longint);
begin
    if (a<>nil) then begin
        if (a^.dato.dni=dni) then begin
            abon:=0;
            pedid:=0;
            while (a^.dato.lista<>nil) do begin
                pedid:=pedid+1;
                abon:= abon+ a^.dato.lista^.dato.monto;
                a^.dato.lista:=a^.dato.lista^.sig
            end
        end
        else
            if (a^.dato.dni>dni) then total (a^.hi,abon,pedid,dni)
        else
            total (a^.hd,abon,pedid,dni);
    end;
end;


var 
a:arbol;
pedid,cant:integer;
fecha:string;
dni:longint;
abon:real;
begin
cant:=0;
forzardatos(a);
writeln ('datos cargados con exito');

imprimirarbol (a);
writeln ('ingrese una fecha (formato dd.mm.aa)');
readln (fecha);
pedidosfecha (a,fecha,cant);
writeln ('la cantidad de clientes que realizaron pedidos en dicha fecha fue de ',cant, ' clientes');

writeln ('ingrese un dni');
readln (dni);
total (a,abon,pedid,dni);
writeln ('la cantidad de pedidos que realizo el cliente de dni ',dni,' fue de ', pedid,' cuyo monto total fue de ', abon:0:2, '$');
end.


