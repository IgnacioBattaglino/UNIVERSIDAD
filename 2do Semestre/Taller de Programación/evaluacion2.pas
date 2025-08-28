program evaluacion2;

type 
envio=record
cliente:integer;
dia:1..31;
cod:integer;
peso:real;
end;

arbol=^nodo;

nodo=record
	dato:envio;
	hd:arbol;
	hi:arbol;
end;

lista=^nodol;
nodol=record
	dato:envio;
	sig:lista;
end;

procedure incisoa (var a:arbol);

procedure leerenvio (var e:envio);
begin
	e.peso:=random(2000)/random(10)+1;
	if (e.peso<>0) then 
	begin
		e.cliente:=random(100)+1;
		e.cod:=random(7500)+1;
		e.dia:=random(31)+1;
	end;
end;

procedure agregararbol (var a:arbol; e:envio);
begin
if (a=nil) then begin  
	new (a);
	a^.dato:=e;
	a^.hi:=nil;
	a^.hd:=nil;
	end
	else if (a^.dato.cod>e.cod) then agregararbol (a^.hd,e)
	else agregararbol (a^.hi,e);

end;

var en:envio;

begin
leerenvio (en);
	while (en.peso>0) do begin
	agregararbol (a,en);
	leerenvio (en);
	end;
end;

procedure incisob (a:arbol;cp:integer; var l:lista);

procedure agregaradelante (var l:lista; e:envio);
	var
	nuevo:lista;
	begin
	new (nuevo);
	nuevo^.dato:=e;
	nuevo^.sig:=l;
	l:=nuevo;
	end;

procedure buscarcp (a:arbol;cp:integer;var l:lista);
begin
if (a<>nil) then
	if (a^.dato.cod<cp) then buscarcp (a^.hd,cp,l)
	else if (a^.dato.cod>cp) then buscarcp (a^.hi,cp,l)
	else if (a^.dato.cod=cp) then begin
	agregarAdelante (l,a^.dato);
	buscarcp (a^.hi,cp,l);
	end;
end;

begin
l:=nil;
buscarcp (a,cp,l);
end;

procedure incisoc(l:lista; var maxp:integer; var minp:integer);

function max (l:lista; maxact:real): integer;
begin
if (l^.sig<>nil) then max:= max (l^.sig,maxact);

if (l^.dato.peso>maxact) then begin
	maxact:=l^.dato.peso;
	max:=l^.dato.cliente;
end;
end;

function min (l:lista; minact:real): integer;
begin
if (l^.sig<>nil) then min:= min (l^.sig,minact);

if (l^.dato.peso<minact) then begin
	minact:=l^.dato.peso;
	min:=l^.dato.cliente;
end;
end;

var maxa,mina:real;
begin
maxa:=-1;
mina:=10000;
maxp:= max(l,maxa);
minp:= min (l,mina);
end;

var
a:arbol;
l:lista;
codcmax,codcmin:integer;

begin
incisoa(a);
incisob(a,1900,l);
incisoc(l, codcmax, codcmin);
end.
