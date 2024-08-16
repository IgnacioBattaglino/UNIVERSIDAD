program crearArchivos;

type

  infoMaestro = record
    codprov, codloc, num, cant: integer;
  end;

  maestro = file of infoMaestro;

var
  mae: maestro;
  texto: text;
  iMas: infoMaestro;

begin
  assign(mae, 'MAESTRO');
  rewrite(mae);
  assign(texto, 'maestro.txt');
  reset(texto);
  while (not eof(texto)) do
  begin
    with iMas do
    begin
      readln(texto,codprov,codloc,num,cant);
      write(mae, iMas);
    end;
  end;
  close(mae);
end.
