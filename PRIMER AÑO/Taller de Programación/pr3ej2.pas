program pr3ej3;

type

fina=record
	nota:1..10;
	cod:integer;
end;
	
lista=^nodol;

nodol=record
	dato:fina;
	sig:lista;
end;

alumno=record
	leg:integer;
	dni:integer;
	ano:2010..2023;
	fin:lista;
end;

arbol=^nodo;

nodo=record
	dato:alumno;
	hi:arbol;
	hd:arbol;
end;

procedure cargarlista (var l:lista);

procedure agregarAdelante(var l: lista; f: fina);
var
  nuevo: lista;
begin
  new(nuevo);
  nuevo^.dato := f;
  nuevo^.sig := nil;
  if (L = nil) then
    L := nuevo
  else begin
    nuevo^.sig := L;
    L := nuevo;
  end;
end;

var aux:fina;
begin
l:=nil;
writeln ('Ingrese el codigo de materia');
readln (aux.cod);
	while (aux.cod<>-1) do begin
	writeln ('ingrese la nota obtenida');
	readln (aux.nota);
	agregaradelante (l,aux);
	writeln ('Ingrese el codigo de materia');
	readln (aux.cod);
end;

end;

procedure cargararbol (var a:arbol);

procedure leer (var al:alumno);
var aux:lista;
begin
writeln ('ingrese el numero de legajo');
readln (al.leg);
if (al.leg<>0) then begin
	writeln ('ingrese el  año de ingreso a la facultad');
	readln (al.ano);
	writeln ('ingrese el dni del alumno');
	readln (al.dni);
	
	cargarlista (aux);
	end
else begin
	aux:=nil;
	end;
end;

procedure agregararbol (var a:arbol; dato:alumno);
begin
if (a=nil) then begin
	new (a);
	a^.dato:=dato;
	a^.hi:=nil;
	a^.hd:=nil;
	end
else 
	if (a^.dato.leg<dato.leg) then agregararbol (a^.hd,dato)
	else agregararbol (a^.hi,dato);
end;

var aux:alumno;
begin
a:=nil;
leer (aux);
while (aux.leg<>0) do begin
	agregararbol (a,aux);
	leer (aux);
end;
end;

procedure alumnosInferioresALegajo(a: arbol; legajoLimite: integer);
begin
  if (a <> nil) then
  begin
   
    if (a^.dato.leg > legajoLimite) then
      alumnosInferioresALegajo(a^.hi, legajoLimite)
    else
    begin
    
      writeln('Legajo: ', a^.dato.leg);
      writeln('DNI: ', a^.dato.dni);
      writeln('Año de ingreso: ', a^.dato.ano);
      writeln;
      alumnosInferioresALegajo(a^.hi, legajoLimite);
    end;
    
    if (a^.dato.leg < legajoLimite) then
    alumnosInferioresALegajo(a^.hd, legajoLimite);
  end;
end;

function maximoleg (a:arbol):integer; 
begin
if (a<>nil) then 
	maximoleg:=maximoleg(a^.hd)
else
	maximoleg:=a^.dato.leg;
end;

function maximoDNI(a: arbol): integer;
var
  dniMaximo, dniIzquierdo, dniDerecho: integer;
begin
  if (a <> nil) then
  begin
    dniMaximo := a^.dato.dni;

    dniIzquierdo := maximoDNI(a^.hi);

    dniDerecho := maximoDNI(a^.hd);

    if (dniIzquierdo > dniMaximo) then
      dniMaximo := dniIzquierdo;

    if (dniDerecho > dniMaximo) then
      dniMaximo := dniDerecho;

    maximoDNI := dniMaximo;
  end
end;

function cantidadimpar (a:arbol):integer;
var cantidad:integer;
begin
if (a<>nil) then begin
	cantidadimpar:= cantidadimpar (a^.hd) + cantidadimpar (a^.hi) +1;
	if  (a^.dato.leg mod 2<>0) then
		cantidad:=cantidad+1;
	end
else
	cantidad:=0;
	
cantidadimpar:=cantidad;
end;

var
  a: arbol;
begin
  cargararbol(a);
writeln (maximoDNI (a));
end.
