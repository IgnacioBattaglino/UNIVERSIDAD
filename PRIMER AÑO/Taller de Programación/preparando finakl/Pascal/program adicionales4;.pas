program adicionales4;
type
reclamo=record
    cod:integer;
    dni:Longint;
    ano:integer;
    tipo:string;
end;

reclamo2=record
    cod:integer;
    ano:integer;
    tipo:string;
end;

lista=^nodol;
nodol=record
    dato:reclamo2;
    sig:lista;
end;

datoarbol=record
    dni:longint;
    lista:lista;
    cant:integer;
end;

arbol=^nodo;
nodo=record
    hd:arbol;
    hi:arbol;
    dato:datoarbol;
end;

procedure agregaradelante (var l:lista; r:reclamo);
var nuevo:lista;
begin
    new (nuevo);
    nuevo^.dato.cod:=r.cod;
    nuevo^.dato.ano:=r.ano;
    nuevo^.dato.tipo:=r.tipo;
    nuevo^.sig:=nil;
    if (l=nil) then
        l:=nuevo
    else
        begin
            nuevo^.sig:=l;
            l:=nuevo;
        end;
end;

procedure agregaralarbol (var a:arbol; r:reclamo);
begin
    if (a=nil) then begin  
        new (a);
        a^.dato.dni:= r.dni;
        a^.hd:=nil;
        a^.hi:=nil;
        agregaradelante (a^.dato.lista, r);
        a^.dato.cant:=1
        end
    else 
        if (a^.dato.dni=r.dni) then begin
            agregaradelante (a^.dato.lista, r);
            a^.dato.cant:=a^.dato.cant+1
        end
    else 
        if (r.dni>a^.dato.dni) then begin
            agregaralarbol (a^.hd,r)

        end
    else
        if (r.dni<a^.dato.dni) then begin
            agregaralarbol (a^.hi,r);        
        end;
end;

(*
procedure lectura (var r:reclamo);
begin
    writeln ('inserte el codigo del reclamo');
    readln (r.cod);
    if (r.cod<>-1) then begin
        writeln ('inserte el dni de la persona que hace el reclamo');
        readln (r.dni);
        writeln ('inserte el año del reclamo');
        readln (r.ano);
        writeln ('inserte el tipo de reclamo');
        readln (r.tipo);
    end;
end;


procedure cargardatos (var a:arbol);
var r:reclamo;
begin
    lectura (r);
    while (r.cod<>-1) do begin
        agregaralarbol (a,r);
        lectura (r);
    end;
end;
*)

procedure cargardatos (var a:arbol);
var r:reclamo;
begin
    r.cod:=1;
    r.dni:=46269132;
    r.ano:=2020;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=2;
    r.dni:=22851780;
    r.ano:=2019;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=3;
    r.dni:=21888378;
    r.ano:=2021;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=4;
    r.dni:=46269132;
    r.ano:=2018;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=5;
    r.dni:=41670832;
    r.ano:=2016;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=6;
    r.dni:=22851780;
    r.ano:=2020;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=7;
    r.dni:=22851780;
    r.ano:=2012;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=8;
    r.dni:=21888378;
    r.ano:=2018;
    r.tipo:='c';
    agregaralarbol (a,r);
    r.cod:=9;
    r.dni:=46269132;
    r.ano:=2020;
    r.tipo:='d';
    agregaralarbol (a,r);
    r.cod:=10;
    r.dni:=22851780;
    r.ano:=2017;
    r.tipo:='b';
    agregaralarbol (a,r);
    r.cod:=11;
    r.dni:=46269132;
    r.ano:=2020;
    r.tipo:='a';
    agregaralarbol (a,r);
    r.cod:=12;
    r.dni:=22851780;
    r.ano:=2020;
    r.tipo:='d';
    agregaralarbol (a,r);
    r.cod:=13;
    r.dni:=41670832;
    r.ano:=2015;
    r.tipo:='c';
    agregaralarbol (a,r);
    r.cod:=14;
    r.dni:=22851780;
    r.ano:=2014;
    r.tipo:='b';
    agregaralarbol (a,r);
    r.cod:=15;
    r.dni:=21888378;
    r.ano:=2010;
    r.tipo:='a';
    agregaralarbol (a,r);
end;

function cantreclamos (a:arbol; dni:longint):smallint;
begin
    if (a=nil) then cantreclamos:=0
    else 
    if (a^.dato.dni=dni) then cantreclamos:= a^.dato.cant
    else 
    if (dni>a^.dato.dni) then cantreclamos:= cantreclamos (a^.hd,dni)
    else
        cantreclamos:= cantreclamos (a^.hi,dni);
end;

procedure cantreclamosentre2dni (a:arbol; dni1,dni2:longint ; var cant:integer);
begin
    if (a<>nil) then begin
        if (a^.dato.dni>=dni1) and (a^.dato.dni<=dni2) then begin
            cant:=cant + a^.dato.cant;
            cantreclamosentre2dni (a^.hd,dni1,dni2,cant);
        end;
        
        if (a^.dato.dni>=dni2) then cantreclamosentre2dni (a^.hi,dni1,dni2,cant)
        else 
            cantreclamosentre2dni (a^.hd,dni1,dni2,cant);
    end;
end;

procedure codigosdeano(a: arbol; ano: integer);
var
  current: lista;
begin
  if (a <> nil) then
  begin
    codigosdeano(a^.hi, ano);
    current := a^.dato.lista;
    while (current <> nil) do
    begin
      if (current^.dato.ano = ano) then
        writeln(current^.dato.cod);
      current := current^.sig;
    end;
    codigosdeano(a^.hd, ano);
  end;
end;

var
a:arbol;
cant:integer;
begin 
    cant:=0;
    a:=nil;
    cargardatos(a);
    writeln ('datos cargados con exito');
    writeln (cantreclamos (a,41670832));
    cantreclamosentre2dni (a,21888378,40000000,cant);
    writeln (cant);
    codigosdeano(a,2020);
end.