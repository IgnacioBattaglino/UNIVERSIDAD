program pr2ej3;
type
  lista = ^nodo;
  nodo = record
    dato: integer;
    sig: lista;
 end;

procedure cargarlista (var l:lista);
procedure agregarAdelante (var l:lista; n:integer);
var nuevo:lista;
begin
	new(nuevo);
	nuevo^.dato:=n;
	nuevo^.sig:=nil;
	
	if (l=nil) then l:=nuevo
	
	else begin
		nuevo^.sig:=l;
		l:=nuevo;
	end;
	end;
	
var n:integer;
begin

randomize;
n:=random (100);
if (n<>0) then begin 
agregarAdelante (l,n);
cargarlista (l);
end;
end;

function minimo (l:lista;minimoact:integer):integer;
	begin
	if (l=nil) then 
	minimo:=minimoact
	else begin
	
	if (minimoact>l^.dato) then 
	minimoact:=l^.dato;
	
	minimo:= minimo(l^.sig,minimoact);
	end; 
end;

function maximo (l:lista;maximoact:integer):integer;
	begin
	if (l=nil) then 
	maximo:=maximoact
	else begin
	
	if (maximoact<l^.dato) then 
	maximoact:=l^.dato;
	
	maximo:= maximo(l^.sig,maximoact);
	end; 
end;

function esta (l:lista;n:integer):boolean;

begin
if (l=nil) then 
	esta:=false
else begin 
	if (l^.dato=n) then esta:=true
else
	esta:= esta(l^.sig,n); 
	
end;
end;y

var l:lista;
min:integer;
max:integer;
begin 
min:=10000;
max:=-10000;
cargarlista (l);
writeln (minimo (l,min));
writeln (maximo (l,max));

if (esta(l,22)) then writeln ('Si esta') else writeln ('No esta');

end.
