program crearArchivos;
type
  infoDetalle=record
    codLocalidad,codCepa,cantCasosActivos,cantCasosNuevos,cantCasosRecu,cantFallecidos:integer;
  end;

  detalle= file of infoDetalle;

  infoMaestro=record
    codLocalidad,codCepa,cantCasosActivos,cantCasosNuevos,cantCasosRecu,cantFallecidos:integer;
    nomLocalidad,nomCepa:string;
  end;

  maestro=file of infoMaestro;

var 
  mae:maestro;
  det:detalle;
  texto:text;
  iDet:infoDetalle;
  iMas:infoMaestro;
  i:integer;
  c:string;
  nombreArchivo:string;
    
begin
  for i := 1 to 3 do 
  begin 
    Str(i,c);
    nombreArchivo:= 'detalle' + c;
    assign(det, nombreArchivo);
    rewrite(det);
    nombreArchivo:= 'DETALLE' + c + '.txt';
    assign(texto, nombreArchivo);
    reset(texto);
    writeln('Escribiendo en el archivo ', nombreArchivo);
    while (not eof(texto)) do 
    begin 
      readln(texto, iDet.codLocalidad, iDet.codCepa ,iDet.cantCasosActivos, iDet.cantCasosNuevos, iDet.cantCasosRecu, iDet.cantFallecidos);
      write(det, iDet);
      writeln('CodLocalidad: ', iDet.codLocalidad, ' CodCepa: ', iDet.codCepa, ' CasosActivos: ', iDet.cantCasosActivos, ' CasosNuevos: ', iDet.cantCasosNuevos, ' CasosRecu: ', iDet.cantCasosRecu, ' Fallecidos: ', iDet.cantFallecidos);
    end;
    close(det);
    close(texto);
  end;

  assign(mae,'maestro');
  rewrite(mae);
  assign(texto, 'MAESTRO.txt');
  reset(texto);
  writeln('Escribiendo en el archivo MAESTRO.txt');
  while (not eof(texto)) do 
  begin 
    readln(texto, iMas.codLocalidad, iMas.codCepa ,iMas.cantCasosActivos, iMas.cantCasosNuevos ,iMas.cantCasosRecu, iMas.cantFallecidos, iMas.nomLocalidad);
    readln(texto, iMas.nomCepa);
    write(mae, iMas);
    writeln('CodLocalidad: ', iMas.codLocalidad, ' CodCepa: ', iMas.codCepa, ' CasosActivos: ', iMas.cantCasosActivos,' CasosNuevos: ', iMas.cantCasosNuevos, ' CasosRecu: ', iMas.cantCasosRecu, ' Fallecidos: ', iMas.cantFallecidos, ' NomLocalidad: ', iMas.nomLocalidad, ' NomCepa: ', iMas.nomCepa);
  end;
  close(mae);
end.
