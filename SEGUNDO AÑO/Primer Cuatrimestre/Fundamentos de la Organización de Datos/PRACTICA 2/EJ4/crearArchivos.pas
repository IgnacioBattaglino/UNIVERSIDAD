program crearArchivos;

type
    infoMaestro = record
        nombre: string;
        alfabetizados: integer;
        encuestados: integer;
    end;
    infoDetalle = record
        nombre: string;
        codigo: integer;
        alfabetizados: integer;
        encuestados: integer;
    end;
    maestro = file of infoMaestro;
    detalle = file of infoDetalle;

procedure crearMaestro(var mae: maestro; var carga: text);
var
    nombre: string;
    infoMae: infoMaestro;
begin
    reset(carga);
    writeln('Ingrese un nombre para el archivo maestro');
    readln(nombre);
    assign(mae, nombre);
    rewrite(mae);
    while(not eof(carga)) do
        begin
            with infoMae do
                begin
                    readln(carga, alfabetizados, encuestados, nombre);
                    write(mae, infoMae);
                end;
        end;
    writeln('Archivo binario maestro creado');
    close(mae);
    close(carga);
end;
procedure crearDetalle(var det: detalle; var carga: text);
var
    nombre: string;
    infoDet: infoDetalle;
begin
    reset(carga);
    writeln('Ingrese un nombre para el archivo detalle');
    readln(nombre);
    assign(det, nombre);
    rewrite(det);
    while(not eof(carga)) do
        begin
            with infoDet do
                begin
                    readln(carga, codigo, alfabetizados, encuestados, nombre);
                    write(det, infoDet);
                end;
        end;
    writeln('Archivo binario detalle creado');
    close(det);
    close(carga);
end;

var

texto:text;
det1:detalle;
det2:detalle;
mae:maestro;

begin 
assign (texto,'detalle1.txt');
crearDetalle (det1,texto);
assign (texto,'detalle2.txt');
crearDetalle (det2,texto);
assign (texto,'maestro.txt');
crearMaestro (mae,texto);
end.