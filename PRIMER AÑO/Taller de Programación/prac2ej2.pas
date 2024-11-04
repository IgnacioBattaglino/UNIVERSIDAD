program pr2ej2;

type
  lista = ^nodo;
  nodo = record
    dato: integer;
    sig: lista;
  end;

procedure cargarlista(var l: lista; var u: lista);

  procedure leernum(var n: integer);
  begin
    writeln('Ingrese un numero');
    readln(n);
  end;

  procedure agregaratras(var l: lista; var u: lista; n: integer);
  var
    nuevo: lista;
  begin
    new(nuevo);
    nuevo^.dato := n;
    nuevo^.sig := nil;
    if l = nil then
      l := nuevo
    else
    begin
      u^.sig := nuevo;
    end;
    u := nuevo;
  end;

var
  n: integer;
begin
  leernum(n);
  while (n <> 0) do
  begin
    agregaratras(l, u, n);
    leernum(n);
  end;
end;

procedure desglosarnum(num: integer);
begin
  if (num <> 0) then
  begin
    desglosarnum(num div 10);
    writeln(num mod 10);
  end;
end;

procedure imprimirnumeros(l: lista);
begin
  if (l <> nil) then
  begin
    desglosarnum(l^.dato);
    imprimirnumeros(l^.sig);
  end;
end;

var
  l: lista;
  u: lista;
begin
  l := nil;
  u := nil;
  cargarlista(l, u);
  imprimirnumeros(l);
end.
