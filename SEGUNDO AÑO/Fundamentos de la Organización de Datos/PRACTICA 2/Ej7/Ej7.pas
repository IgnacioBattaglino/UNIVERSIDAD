program ej7;

const 
  valorAlto = 9999;
  dimf = 3;

type 
  subrango = 1..dimf;

  infoDetalle = record
    codLocalidad, codCepa, cantCasosActivos, cantCasosNuevos, cantCasosRecu, cantFallecidos: integer;
  end;

  infoMaestro = record
    codLocalidad, codCepa, cantCasosActivos, cantCasosNuevos, cantCasosRecu, cantFallecidos: integer;
    nomLocalidad, nomCepa: string;
  end;
  
  detalle = file of infoDetalle;
  maestro = file of infoMaestro;
  vecDet = array [subrango] of detalle;
  vecReg = array [subrango] of infoDetalle;

procedure leer(var det: detalle; var dato: infoDetalle);
begin
  if not eof(det) then
    read(det, dato)
  else
    dato.codLocalidad := valorAlto;  
end;    

procedure findminimo(var ar: vecDet; var reg: vecReg; var min: infoDetalle);
var 
  i, pos: subrango;
begin
  min.codLocalidad := valorAlto;
  for i := 1 to dimF do 
    if reg[i].codLocalidad < min.codLocalidad then begin
      min := reg[i]; 
      pos := i;
    end;
  if min.codLocalidad <> valorAlto then 
    leer(ar[pos], reg[pos]);
end;

procedure imprimirMaestro(var mae: maestro);
var
  s: infoMaestro;
begin
  reset(mae);
  while not eof(mae) do begin
    read(mae, s);
    writeln(' CodLocalidad: ', s.codLocalidad, ' CodCepa ', s.codCepa, ' Casos activos ', s.cantCasosActivos, ' Casos nuevos ', s.cantCasosNuevos, ' Casos recuperados ', s.cantCasosRecu, ' Fallecidos ', s.cantFallecidos);
  end;
  close(mae);
end;

var
  mae: maestro;
  iMae: infoMaestro;
  minimo: infoDetalle;
  vectorDet: vecDet;
  vectorReg: vecReg;
  nombreArchivo, c: string;
  cant, cantloc: integer;
  i: subrango;

begin 
  for i := 1 to dimf do begin
    Str(i, c);
    nombreArchivo := 'detalle' + c; 
    assign(vectorDet[i], nombreArchivo);
    reset(vectorDet[i]);
    leer(vectorDet[i], vectorReg[i]);
  end;

  assign(mae, 'maestro');
  reset(mae);
  findminimo(vectorDet, vectorReg, minimo);
  cant := 0;
  cantloc := 0;
  read(mae, iMae);

  while minimo.codLocalidad <> valorAlto do begin
    while (not eof(mae)) and (minimo.codLocalidad <> iMae.codLocalidad) do
      read(mae, iMae);
    while minimo.codLocalidad = iMae.codLocalidad do begin
      while minimo.codCepa <> iMae.codCepa do 
        read(mae, iMae);
      while (minimo.codLocalidad = iMae.codLocalidad) and (minimo.codCepa = iMae.codCepa) do begin
        writeln(' iMae.cantFallecidos ', iMae.cantFallecidos, ' minimo.cantFallecidos ', minimo.cantFallecidos);
        iMae.cantFallecidos := iMae.cantFallecidos + minimo.cantFallecidos;
        iMae.cantCasosRecu := iMae.cantCasosRecu + minimo.cantCasosRecu;
        iMae.cantCasosActivos := minimo.cantCasosActivos;
        iMae.cantCasosNuevos := minimo.cantCasosNuevos;
        cant := cant + minimo.cantCasosActivos;
        findminimo(vectorDet, vectorReg, minimo);
      end;
      seek(mae, filepos(mae)-1);
      write(mae, iMae);
    end;
    if cant > 50 then 
      cantloc := cantloc + 1;
    cant := 0;
  end;
  close(mae);
  for i := 1 to dimf do
    close(vectorDet[i]);
  
  imprimirMaestro(mae);
  writeln('Cantidad de localidades con mas de 50 casos activos:', cantloc);
end.
