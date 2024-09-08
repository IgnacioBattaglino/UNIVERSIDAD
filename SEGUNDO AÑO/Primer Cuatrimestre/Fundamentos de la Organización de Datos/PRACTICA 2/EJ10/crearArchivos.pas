program crearArchivos;

type
  infoMaestro = record
    dep, divi, num,cat,cant: integer;
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
      readln(texto,dep,divi,num,cat,cant);
      write (mae, iMas);
    end;
  end;
  close(mae);
end.
