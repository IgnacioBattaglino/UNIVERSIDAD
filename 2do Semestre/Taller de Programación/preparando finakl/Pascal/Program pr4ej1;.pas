Program pr4ej1;

type

producto=record
    cod:integer;
    uv:integer;
    mon:real;
end;

venta=record
    codp:integer;
    cod:integer;
    uv:integer;
    pre:real;
end;

arbol=^nodo;

nodo=record
    dato:producto;
    hd:arbol;
    hi:arbol;
end;



procedure leerdatos (var v:venta) ;
begin
    writeln ('ingrese el codigo de la venta');
    readln (v.cod);
    if (v.cod<>-1) then begin
        writeln ('ingrese el codigo del producto');
        readln (v.codp);
        writeln ('ingrese la cantidad de unidades vendidas');
        readln (v.uv);
        writeln ('ingrese el precio por unidad');
        readln (v.pre);
    end;    
end;

procedure agregaralarbol (var a:arbol; v:venta);
begin
    if (a=nil) then begin
        new (a);
        a^.dato.cod:=v.codp;
        a^.dato.uv:=v.uv;
        a^.dato.mon:= v.uv*v.pre;
        a^.hd:=nil;
        a^.hi:=nil
    end    
    else if (a^.dato.cod=v.codp) then begin
        a^.dato.uv:=a^.dato.uv+v.uv;
        a^.dato.mon:= a^.dato.mon+v.uv*v.pre
    end
    else if (a^.dato.cod>v.codp) then agregaralarbol (a^.hi,v)
    else 
        agregaralarbol (a^.hd,v);
end;

(*
procedure cargardatos (var a:arbol);
var v:venta;
begin
    leerdatos (v);
    while (v.cod<>-1) do begin
        agregaralarbol(a,v);
        leerdatos (v);
    end;
end;
*)

procedure forzardatos (var a:arbol);
var v:venta;
begin
    v.codp:=45;
    v.cod:=1;
    v.uv:=10;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=23;
    v.cod:=2;
    v.uv:=50;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=31;
    v.cod:=3;
    v.uv:=30;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=45;
    v.cod:=4;
    v.uv:=20;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=54;
    v.cod:=5;
    v.uv:=8;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=15;
    v.cod:=6;
    v.uv:=15;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=15;
    v.cod:=100;
    v.uv:=100;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=2;
    v.cod:=7;
    v.uv:=100;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=3;
    v.cod:=8;
    v.uv:=600;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=4;
    v.cod:=9;
    v.uv:=1000;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=5;
    v.cod:=10;
    v.uv:=5;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=17;
    v.cod:=11;
    v.uv:=10;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=21;
    v.cod:=22;
    v.uv:=50;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=32;
    v.cod:=13;
    v.uv:=30;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=44;
    v.cod:=74;
    v.uv:=20;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=53;
    v.cod:=55;
    v.uv:=8;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=123;
    v.cod:=63;
    v.uv:=15;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=151;
    v.cod:=310;
    v.uv:=100;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=22;
    v.cod:=71;
    v.uv:=100;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=30;
    v.cod:=80;
    v.uv:=600;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=4;
    v.cod:=9;
    v.uv:=1000;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=5;
    v.cod:=10;
    v.uv:=5;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=45;
    v.cod:=1;
    v.uv:=10;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=23;
    v.cod:=2;
    v.uv:=50;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=31;
    v.cod:=3;
    v.uv:=30;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=45;
    v.cod:=4;
    v.uv:=20;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=54;
    v.cod:=5;
    v.uv:=8;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=15;
    v.cod:=6;
    v.uv:=15;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=15;
    v.cod:=100;
    v.uv:=100;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=2;
    v.cod:=7;
    v.uv:=100;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=3;
    v.cod:=8;
    v.uv:=600;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=4;
    v.cod:=9;
    v.uv:=1000;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=5;
    v.cod:=10;
    v.uv:=5;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=17;
    v.cod:=11;
    v.uv:=10;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=21;
    v.cod:=22;
    v.uv:=50;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=32;
    v.cod:=13;
    v.uv:=30;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=44;
    v.cod:=74;
    v.uv:=20;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=53;
    v.cod:=55;
    v.uv:=8;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=123;
    v.cod:=63;
    v.uv:=15;
    v.pre:=100;
    agregaralarbol (a,v);
    v.codp:=151;
    v.cod:=310;
    v.uv:=100;
    v.pre:=15;
    agregaralarbol (a,v);
    v.codp:=22;
    v.cod:=71;
    v.uv:=100;
    v.pre:=30;
    agregaralarbol (a,v);
    v.codp:=30;
    v.cod:=80;
    v.uv:=600;
    v.pre:=1;
    agregaralarbol (a,v);
    v.codp:=4;
    v.cod:=9;
    v.uv:=1000;
    v.pre:=5;
    agregaralarbol (a,v);
    v.codp:=5;
    v.cod:=10;
    v.uv:=5;
    v.pre:=15;
    agregaralarbol (a,v);       
end;

procedure imprimirarbol (a:arbol);
begin
    if (a<>nil) then begin
        imprimirarbol (a^.hi);
        writeln ('cod ', a^.dato.cod);
        writeln ('unidades vendidas ', a^.dato.uv);
        writeln ('monto total ', a^.dato.mon:0:2);
        imprimirarbol (a^.hd);
    end;
end;

procedure calcularmaximo (a:arbol; var maxp,maxu:integer);
begin
    if (a<>nil) then begin
        if (a^.dato.uv>maxu) then begin
            maxp:=a^.dato.cod;
            maxu:=a^.dato.uv;
        end;
        calcularmaximo (a^.hi,maxp,maxu);
        calcularmaximo (a^.hd,maxp,maxu);
    end;
end;

function maxuv (a:arbol):integer;
var
maxp,maxu:integer;
begin
    maxp:=-1;
    maxu:=-1;
    calcularmaximo (a,maxp,maxu);
    maxuv:= maxp;
end;

function contar (a:arbol):integer;
begin
    if (a<>nil) then 
        contar:= 1 + contar (a^.hi) + contar (a^.hd) 
    else
        contar:= 0;
end;

function contar2 (a:arbol;cod:integer):integer;
begin
    if (a<>nil) and (a^.dato.cod<cod) then 
        contar2:= 1 + contar2 (a^.hi,cod) + contar2 (a^.hd,cod) 
    else
        contar2:= 0;
end;

procedure cantidadcodigosmenores (a:arbol; cod:integer; var cant:integer);
begin
    if (a^.dato.cod=cod) then cant:= contar(a^.hi)
    else
        if (a^.dato.cod<cod) then cant:= contar2(a,cod)
    else
        cantidadcodigosmenores (a^.hi,cod,cant);
end;

function cant(a:arbol;cod:integer):integer;
var aux:integer;
begin
    aux:=0;
    cantidadcodigosmenores (a,cod,aux);
    cant:= aux;
end;

function montot (a:arbol;cod1,cod2:integer):real;
begin
    if (a=nil) then montot:=0
    else
        if (a^.dato.cod>cod1) and (a^.dato.cod<cod2) then begin
            montot:= a^.dato.mon + montot (a^.hi,cod1,cod2) + montot (a^.hd,cod1,cod2);
        end
        else if (a^.dato.cod<=cod1) then montot:= montot (a^.hd,cod1,cod2)
        else if (a^.dato.cod>=cod2) then montot:= montot (a^.hi,cod1,cod2);
end;

var
a:arbol;
v1,v2:integer;
begin
  // cargardatos (a);
  forzardatos (a);
  writeln ('datos cargados con exito');
  imprimirarbol (a);
  writeln ('el codigo de producto con mas unidades vendidas es el ', maxuv(a));
  writeln ('la cantidad de codigos menores al 123 es de ', cant(a,123));
  writeln ('ingrese dos codigos');
  readln (v1);
  readln(v2);
  writeln ('el monto total entre los dos codigos ingresados es de ', montot (a,v1,v2):0:2);
end.