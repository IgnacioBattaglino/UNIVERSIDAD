program evaluacion3.pas;

type
sub_mes=1..12;

compra=record
	codc:integer;
	mes:sub_mes;
	mon:real;
end;

vector=array [sub_mes] of real;

cliente=record
	cod:integer;
	total:vector;
end;

arbol=^nodo;

nodo=record
	dato:cliente;
	hi:arbol;
	hd:arbol
end;

procedure inicializarvector (var v:vector);
var i:integer;
begin
for i:=1 to 12 do 
	v[i]:=0;
end;

procedure leercompra(var c: compra);
begin
  writeln('Ingrese el código del cliente (0 para finalizar): ');
  readln(c.codc);
  if (c.codc <> 0) then
  begin
    writeln('Ingrese el mes (1-12): ');
    readln(c.mes);
    writeln('Ingrese el monto de la compra: ');
    readln(c.mon);
  end;
end;

procedure agregararbol (var a:arbol; c:compra);
begin
if (a=nil) then begin
	new(a);
	inicializarvector (a^.dato.total);
	a^.dato.cod:=c.codc;
	a^.dato.total[c.mes]:=a^.dato.total[c.mes]+ c.mon;
	a^.hi:=nil;
	a^.hd:=nil;
	end
else if (a^.dato.cod<c.codc) then agregararbol (a^.hd,c) 
else if (a^.dato.cod>c.codc) then agregararbol (a^.hi,c)
else a^.dato.total[c.mes]:=a^.dato.total[c.mes]+ c.mon;

end;

procedure incisoa (var a:arbol);
var
c:compra;
begin
a:=nil;
leercompra (c);
while (c.codc<>0) do begin
	agregararbol (a,c);
	leercompra (c);
	end;
end;

function maxvector (v:vector):sub_mes;
var
maxact:real;
maxv:sub_mes;
i:integer;
begin
maxact:=-1;
for i:=1 to 12 do begin
	if v[i]>maxact then begin
	maxact:=v[i];
	maxv:=i;
	end;
end;
maxvector:=maxv;
end;

function mayorgasto (a:arbol;c:integer):integer;

begin
if (a=nil) then
	mayorgasto:=0 // si no se encuentra el cliente, el procedimiento devuelve el valor 0.
else if (c>a^.dato.cod) then mayorgasto:=mayorgasto (a^.hi,c)
else if (c<a^.dato.cod) then mayorgasto:=mayorgasto (a^.hd,c)
else mayorgasto:= maxvector (a^.dato.total);

end;

function escero (v:vector;m:sub_mes):boolean;
begin
if (v[m]=0) then escero:=true
else
	escero:=false;
end;

procedure enorden (a:arbol; m:sub_mes; var cant:integer);
begin
if (a<>nil) then begin
enorden (a^.hi,m,cant);
if (escero(a^.dato.total,m)) then cant:=cant+1;
enorden (a^.hd,m,cant);
end;
end;


var
a:arbol;
cant:integer;
begin
incisoa (a);
writeln (mayorgasto (a,100));
enorden (a,12,cant);
writeln ('La cantidad de clientes que no gastaron nada en el mes de diciembre fue de ', cant);
end.
