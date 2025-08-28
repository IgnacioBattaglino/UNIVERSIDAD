Program parcial1;
type
alquiler=record
    dni:longint;
    anio:integer;
    mes:1..12;
    pat:string;
end;    

alquiler2=record
    dni:longint;
    anio:integer;
    mes:1..12;
end;   

lista=^nodo2;
nodo2=record
    dato:alquiler2;
    sig:lista;
end;

datoarbol=record
    pat:string;
    lista:lista;
end;

arbol=^nodo;
nodo=record
    dato:datoarbol;
    hd:arbol;
    hi:arbol;
end;

procedure leerInformacion (var a:alquiler);
begin
    writeln ('Ingrese la patente del vehiculo alquilado');
    readln (a.pat);
    if (a.pat<>'0') then begin
        writeln ('Ingrese el dni del cliente');
        readln (a.dni);
        writeln ('Ingrese el año del alquiler');
        readln (a.anio);
        writeln ('Ingrese el mes del alquiler');
        readln (a.mes);
    end;
end;

procedure agregaradelante (var l:lista; al:alquiler);
var 
nuevo:lista;
begin
    new (nuevo);
    nuevo^.sig:=nil;
    nuevo^.dato.mes:=al.mes;
    nuevo^.dato.anio:=al.anio;
    nuevo^.dato.dni:=al.dni;
    nuevo^.sig:=l;
    l:=nuevo;
end;

procedure agregaralarbol (var a:arbol; al:alquiler);
begin 
    if (a=nil) then begin
        new (a);
        a^.dato.pat:= al.pat;
        agregaradelante (a^.dato.lista,al);
        a^.hd:=nil;
        a^.hi:=nil
    end
    else
        if (al.pat=a^.dato.pat) then agregaradelante (a^.dato.lista,al)
    else
        if (al.pat>a^.dato.pat) then agregaralarbol (a^.hd,al)
    else
        agregaralarbol (a^.hd,al);
        
    
end;

(*
procedure cargararbol (var a:arbol);
var 
al:alquiler;
begin
    leerInformacion (al);
    while (al.pat<>'0') do begin
        agregaralarbol (a,al);
        leerInformacion (al);
    end;
     writeln('Lectura de datos finalizada');
end;     
*)  
  
procedure cargararbol (var a:arbol);
var 
al:alquiler;
begin
    al.pat:= 'AE233TA';
    al.dni:= 46269132;
    al.anio:= 2020;
    al.mes:= 12;
    agregaralarbol (a,al);
    al.pat:= 'AD221KB';
    al.dni:= 21888378;
    al.anio:= 2022;
    al.mes:= 10;
    agregaralarbol (a,al);
    al.pat:= 'AAA111';
    al.dni:= 1241244;
    al.anio:= 2019;
    al.mes:= 9;
    agregaralarbol (a,al);
    al.pat:= 'AE233TA';
    al.dni:= 46269132;
    al.anio:= 2020;
    al.mes:= 12;
    agregaralarbol (a,al);
    al.pat:= 'AD221KB';
    al.dni:= 21888378;
    al.anio:= 2022;
    al.mes:= 10;
    agregaralarbol (a,al);
    al.pat:= 'AAA111';
    al.dni:= 124124241;
    al.anio:= 2019;
    al.mes:= 9;
    agregaralarbol (a,al);
    al.pat:= 'AE233TA';
    al.dni:= 46269132;
    al.anio:= 2020;
    al.mes:= 12;
    agregaralarbol (a,al);
    al.pat:= 'AD221KB';
    al.dni:= 21888378;
    al.anio:= 2023;
    al.mes:= 5;
    agregaralarbol (a,al);
    al.pat:= 'AAA111';
    al.dni:= 41670832;
    al.anio:= 2019;
    al.mes:= 8;
    agregaralarbol (a,al);
    al.pat:= 'AE233TA';
    al.dni:= 46269132;
    al.anio:= 2015;
    al.mes:= 7;
    agregaralarbol (a,al);
    al.pat:= 'AD221KB';
    al.dni:= 2049104;
    al.anio:= 2016;
    al.mes:= 2;
    agregaralarbol (a,al);
    al.pat:= 'AAA111';
    al.dni:= 22851780;
    al.anio:= 2017;
    al.mes:= 1;
    agregaralarbol (a,al);
    writeln('Lectura de datos finalizada');
end;

function cantDniEnLista (l:lista;dni:longint):integer;
begin
    if (l<>nil) then begin
        if (l^.dato.dni=dni) then 
            cantDniEnLista:= 1 + cantDniEnLista (l^.sig,dni)
        else
            cantDniEnLista:= cantDniEnLista (l^.sig,dni)
    end
    else
        cantDniEnLista:=0;
end;

function cantDNI (a:arbol ; dni:longint):integer;
begin
    if (a<>nil) then 
        cantDNI:= cantDniEnLista (a^.dato.lista,dni) + cantDNI (a^.hd,dni) + cantDNI (a^.hi,dni)
    else
        cantDNI:=0;
end;

function cantAlquileresAnio (l:lista;anio:integer):integer;
begin
    if (l<>nil) then begin
        if (l^.dato.anio=anio) then cantAlquileresAnio:= 1 + cantAlquileresAnio (l^.sig,anio)
        else
            cantAlquileresAnio:= cantAlquileresAnio (l^.sig,anio);
    end
    else 
        cantAlquileresAnio:= 0;
end;

function cantAlquileresEntreAyB (ar:arbol; anio:integer; A,B:string):integer;
begin
    if (ar<>nil) then begin
        if (ar^.dato.pat>= A) and (ar^.dato.pat<= B) then cantAlquileresEntreAyB := cantAlquileresAnio (ar^.dato.lista,anio) + cantAlquileresEntreAyB (ar^.hd,anio,A,B) + cantAlquileresEntreAyB (ar^.hi,anio,A,B);
        
        if (ar^.dato.pat<A) then cantAlquileresEntreAyB := cantAlquileresEntreAyB (ar^.hd,anio,A,B)
        else
            if (ar^.dato.pat>B) then cantAlquileresEntreAyB := cantAlquileresEntreAyB (ar^.hi,anio,A,B)
    end
    else
        cantAlquileresEntreAyB := 0;
end;




var 
a:arbol;

begin
  a:=nil;
  cargararbol(a);
  writeln (cantDNI (a, 41670832));
  writeln (cantAlquileresEntreAyB (a, 2019 ,'AAA111','ZZZ222'));
end.

