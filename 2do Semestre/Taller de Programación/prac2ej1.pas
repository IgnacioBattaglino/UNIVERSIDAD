program prac2ej1;
const
dimf=10;
type
vector=array [1..dimf] of char;

lista=^nodo;
nodo=record
	dato:char;
	sig:lista;
	end;

procedure leercaracteres (var v:vector; var diml:integer);
var c:char;
begin
readln (c);
if (diml<dimf) and (c<>'.') then begin
diml:=diml+1;
v [diml]:=c;
leercaracteres (v,diml);
end;
end;

procedure imprimir (v:vector;diml:integer);
var i:integer;
begin
for i:=1 to diml do begin
	writeln (v[i]);
end;
end;

procedure imprimirrecursivo (v:vector;diml:integer;var i:integer);
begin
if (i<>diml+1) then begin
	writeln (v[i]);
	imprimirrecursivo (v,diml,i+1);
end;
end;

function caracteres (var car:char):integer;
begin
readln (car);
if (car<>'.') then
	caracteres:=caracteres+1
else
	caracteres:=0;
end;

procedure agregarAdelante(var L: lista; car: char);
var
  nuevo: lista;
begin
  new(nuevo);
  nuevo^.dato := car;
  nuevo^.sig := nil;
  if (L = nil) then
    L := nuevo
  else begin
    nuevo^.sig := L;
    L := nuevo;
  end;
end;

procedure list (var l:lista);
var c:char;
begin
read (c);
if (c<>'.') then begin
agregaradelante (l,c);
list (l);
end;
end;

procedure imprimirlista (l:lista);
begin
if (l<>nil) then begin
writeln (l^.dato);
imprimirlista (l^.sig);
end;

end;

procedure imprimirlistaalreves (l:lista);
begin
if (l<>nil) then 
	imprimirlistaalreves (l^.sig);

writeln (l^.dato);

end;


var
c:char;

begin

caracteres (c);

end.
