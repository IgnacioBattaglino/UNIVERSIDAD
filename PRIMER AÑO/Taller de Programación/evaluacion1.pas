program evaluacion1;

type

comprac=record
	codc,codv:integer;
	dia:1..31;
	mes:1..12;
end;

compra=record
	codv:integer;
	dia:1..31;
	mes:1..12;
end;

lista=^nodol;

nodol=record
	dato:compra;
	sig:lista;
end;

cliente=record
	codc:integer;
	compras:lista;
end;

arbol=^nodo;
nodo=record
	dato:cliente;
	hd:arbol;
	hi:arbol;
end;

comprasxmes= array [1..12] of integer;



procedure incisoa (var a:arbol;var cxm:comprasxmes);
	
procedure inicializarvector (var v:comprasxmes);
var i:integer;
begin
for i:=1 to 12 do begin
	v[i]:=0;
end;
end;

procedure leercompra (var c:comprac);
begin
c.codc:= random(100);
if (c.codc<>0)then begin
	c.dia:=random (31)+1;
	c.mes:= random(12)+1;
	c.codv:= random (20000)+1;
end;
end;

procedure agregaradelante (var l:lista; c:compra);
	var
	nuevo:lista;
	begin
	new (nuevo);
	nuevo^.dato:=c;
	nuevo^.sig:=l;
	l:=nuevo;
	end;
	
procedure acomodarregistro (c:comprac; var cp:compra);
begin
	cp.codv:=c.codv;
	cp.dia:=c.dia;
	cp.mes:=c.mes;
end;

procedure agregararbol (var a:arbol; dato:comprac);
var c:compra;
begin
if (a=nil) then begin
	new (a);
	a^.dato.codc:=dato.codc;
	acomodarregistro (dato,c);
	a^.hi:=nil;
	a^.hd:=nil;
	agregaradelante (a^.dato.compras,c);
	end
else 
	if (a^.dato.codc<dato.codc) then agregararbol (a^.hd,dato)
	else if (a^.dato.codc>dato.codc) then agregararbol (a^.hi,dato)
	else begin
	acomodarregistro (dato,c);
	agregaradelante (a^.dato.compras,c);
	end;
end;

var c:comprac;
begin
a:=nil;
inicializarvector(cxm);
leercompra (c);
while (c.codc<>0) do begin
	agregararbol (a,c);
	cxm[c.mes]:=cxm[c.mes]+1;
	leercompra (c);
end;
end;

function buscarcli (a:arbol; c:integer):lista; // inciso b
begin
if (a=nil) then 
	buscarcli:=nil
else 
	if (a^.dato.codc>c) then buscarcli:= buscarcli (a^.hi,c) 
	else if (a^.dato.codc<c) then buscarcli:= buscarcli (a^.hd,c)
	else buscarcli:=a^.dato.compras; 
end;


procedure incisoc (var v:comprasxmes); // ordenamiento de vector;
var 
i,j,pos,item:integer;
begin
for i:=1 to 11 do begin //11 = dimlog-1
	pos:=i;
	for j:= i+1 to 11 do
		if v[j] < v[pos] then pos:=j;
		
	item:= v[pos];
	v[pos]:= v[i];
	v[i]:=item;
end;
end;

var
a:arbol;
v:comprasxmes;
listacli1:lista;
listacli2:lista;
	begin
		incisoa (a,v);
		listacli1:=buscarcli (a,100);
		listacli2:=buscarcli (a,101);
		incisoc (v);
		
		
	end.
