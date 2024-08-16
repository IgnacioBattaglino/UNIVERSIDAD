program crearArchivos;

type
  cliente = record
    cod: integer;
    nomcompleto: string;
  end;

  infoMaestro = record
    cli: cliente;
    mes, dia, ano: integer;
    monto: real;
    nomLocalidad, nomCepa: string;
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
      readln(texto, cli.cod, ano, mes, dia, monto, cli.nomcompleto);
      write(mae, iMas);
      // Imprimir los campos después de escribirlos en el archivo
      writeln('Codigo:', cli.cod);
      writeln('Nombre Completo:', cli.nomcompleto);
      writeln('Ano:', ano);
      writeln('Mes:', mes);
      writeln('Dia:', dia);
      writeln('Monto:', monto:0:2);
    end;
  end;
  close(mae);
end.
