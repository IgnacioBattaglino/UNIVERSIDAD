program pr_ordenacion_ej4;

type

producto=record
	cod:integer;
	codr:1..8;
	pre:real;
end;

lista:^nodo;

nodo=record
	dato:producto;
	sig:lista;
end;

procedure cargarlista (var l:lista); 

procedure agregarordenado (var l:lista; p:producto);
var nuevo,ant,act:lista;

begin
new (nuevo);
nuevo^.dato:=p;
act:=l;

while (act<>nil) and (act^.dato.cod < p.cod) do begin
	ant:=act;
	act:=act^.sig;
end;
	if (act=l) then l:=nuevo;
	else
		ant^.sig:=nuevo;

nuevo^.sig:=act; 

end;


procedure leer(var p:producto);
begin
writeln ('Ingrese el precio del producto');
readln (p.pre);
	if (p.pre<>0)then begin
writeln ('Ingrese el codigo de producto');
readln (p.cod);
writeln ('Ingrese el codigo de rubro (1 a 8)');
readln (p.codr)
end;

var produ:producto;

begin
leer (produ);
while (produ.pre<>0) do begin
	agregarordenado (l,produ);
	leer (produ); 
	
if (produ.pre=0) then writeln ('se ingreso el precio $0, finalizando lectura.');
end
