program ej8;
const 
    valorAlto=9999;
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


procedure leer (var archivo: maestro; var dato:infoMaestro);
begin 
    if (not eof(archivo)) then
        read (archivo,dato)
    else 
        dato.cli.cod:=valorAlto;
end;

procedure obtener_reporte(var archivo: maestro);
var 
    totalventas, totalmes,totalano: real;
    leido: infoMaestro;
    actcod,actano,actmes:integer;
begin
    totalventas:=0;
    leer(archivo, leido);
    while (leido.cli.cod <> valorAlto) do // Continuar mientras no se alcance el final del archivo
    begin
        actcod := leido.cli.cod;
        writeln('Nombre del cliente: ', leido.cli.nomcompleto, ' Cod: ', leido.cli.cod);
        while (actcod= leido.cli.cod) do // Continuar mientras el código de cliente sea el mismo
        begin
            writeln('Compras del año ', leido.ano, ':');
            totalano:=0;
            actano:=leido.ano;
            while (actcod = leido.cli.cod) and (actano = leido.ano) do // Continuar mientras el año sea el mismo
            begin
                totalmes := 0;
                actmes:= leido.mes;
                while (actcod= leido.cli.cod) and (actano=leido.ano) and (actmes = leido.mes)  do // Continuar mientras el mes sea el mismo
                begin
                    totalmes := totalmes + leido.monto;
                    leer(archivo, leido); // Leer el siguiente registro
                end;
                writeln('Mes ', actmes, ': ', totalmes:0:2);
                totalano := totalano + totalmes;
                
            end;
            totalventas:=totalventas + totalano;
            writeln ('Ventas totales del anio: ', totalano:0:2);
        end;
    end;
    writeln ('El total de ventas de la compania es de: ', totalventas:0:2);
end;

var
mae:maestro;

begin
    assign (mae,'MAESTRO');
    reset (mae);
    obtener_reporte (mae);
    close (mae);
end.