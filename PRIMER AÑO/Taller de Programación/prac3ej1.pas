program ej3;
type
  alumno = record
    legajo: integer;
    dni: integer;
    ingreso: integer;
    notas: lista;
  end;
  nota = record
    codigo: integer;
    nota: real;
  end;
  lista = ^nodoLista;
  nodoLista = record
    info: nota;
    sig: lista;
  end;
  arbol = ^nodoArbol;
  nodoArbol = record
    info: alumno;
    HI: arbol;
    HD: arbol;
  end;

procedure armarNodo(var L: lista);
var
  nuevo: lista;
  aux: integer;
begin 
  writeln('Ingrese el codigo de la materia');
  readln(aux);
  while (aux <> -1) do begin
    new(nuevo);
    nuevo^.info.codigo := aux;
    writeln('Ingrese la nota obtenida en la materia');
    readln(nuevo^.info.nota);
    nuevo^.sig := nil;
    if (L = nil) then
      L := nuevo
    else begin
      nuevo^.sig := L;
      L := nuevo;
    end;
    writeln('Ingrese el codigo de la materia');
    readln(aux);
  end;
end;

procedure agregar(var a: arbol; valor: integer);
begin
  if (a = nil) then begin
    new(a);
    a^.info.legajo := valor;
    writeln('Ingrese el DNI del alumno');
    readln(a^.info.dni);
    writeln('Ingrese el anio de ingreso del alumno');
    readln(a^.info.ingreso);
    armarNodo(a^.info.notas);
    a^.HI := nil;
    a^.HD := nil;
  end
  else if (valor <= a^.info.legajo) then 
    agregar(a^.HI, valor)
  else  
    agregar(a^.HD, valor);
end;

procedure dispararArbol(var a: arbol);
var
  aux: integer;
begin
  a := nil;
  writeln('Ingrese el legajo del alumno');
  readln(aux);
  while (aux <> 0) do begin
    agregar(a, aux);
    writeln('Ingrese el legajo del alumno');
    readln(aux);
  end;
end;

procedure contadorMenores(a: arbol; numero: integer);
begin
  while (a <> nil) do begin
    if (a^.info.legajo = numero) then begin
      while (a <> nil) do begin
        a := a^.HI;
        writeln(a^.info.dni);
        writeln(a^.info.ingreso);
      end;
    end
    else if (a^.info.legajo < numero) then begin
      while (a <> nil) do begin
        writeln(a^.info.dni);
        writeln(a^.info.ingreso);
        a := a^.HI;
      end;
    end
    else if (a^.info.legajo > numero) then begin
      while (a <> nil) and (a^.info.legajo > numero) do begin
        a := a^.HI;
      end;
      while (a <> nil) do begin
        writeln(a^.info.dni);
        writeln(a^.info.ingreso);
        a := a^.HI;
      end;
    end;
  end;
end;

function maxLegajo(a: arbol): integer;
begin
  if (a^.HD = nil) then
    maxLegajo := a^.info.legajo
  else 
    maxLegajo := maxLegajo(a^.HD);
end;

procedure actualizarMaximos(dni: integer; var maxDNI: integer);
begin
  if (dni > maxDNI) then 
    maxDNI := dni;
end;

procedure verMaximos(a: arbol; var maxDNI: integer;);
begin
  if (a <> nil) then begin
    verMaximos(a^.HI, maxDNI);
    verMaximos(a^.HD, maxDNI);
    actualizarMaximos(a^.info.dni, maxDNI);
  end;
end;

function maxDNI(a: arbol): integer;
var
  max: integer;
begin
  max := -1;
  verMaximos(a, max);
  maxDNI := max;
end;

function legajoImpar(a: arbol): integer;
begin
  if (a <> nil) and (a^.info.legajo MOD 2 <> 0) then 
    legajoImpar := legajoImpar(a^.HI) + legajoImpar(a^.HD) + 1;
end;
