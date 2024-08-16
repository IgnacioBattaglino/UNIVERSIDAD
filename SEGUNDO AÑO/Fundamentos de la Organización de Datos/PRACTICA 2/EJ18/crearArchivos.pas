program GenerarArchivosDetalle;
const
  CantidadRegistros = 100; // Cambia según la cantidad de registros que desees generar

type
  direccion = record
    calle, nro, piso, dto: integer;
    ciudad: string;
  end;

  infoDetalle1 = record
    nro, mat: integer;
    dir: direccion;
    nom, ape, nomM, apeM, dni, dniM, dniP, nomP, apeP: string;
  end;

  infoDetalle2 = record
    nro, mat: integer;
    nom, ape, fecha, hora, lugar: string;
  end;

  detalle1 = file of infoDetalle1;
  detalle2 = file of infoDetalle2;

procedure GenerarDatosNacimiento(var det: detalle1);
var
  i: integer;
  idet: infoDetalle1;
  c: string; // Variable para almacenar el resultado de Str
begin
  rewrite(det);
  for i := 1 to CantidadRegistros do
  begin
    with idet do
    begin
      nro := i;
      mat := Random(1000); // Matrícula aleatoria del médico
      dir.calle := Random(1000);
      dir.nro := Random(100);
      dir.piso := Random(10);
      dir.dto := Random(10);
      dir.ciudad := 'Ciudad ' + c; // Utilizando el resultado de Str
      nom := 'Nombre' + c;
      ape := 'Apellido' + c;
      nomM := 'NombreMadre' + c;
      apeM := 'ApellidoMadre' + c;
      dni := c; // DNI aleatorio
      dniM := c;
      dniP := c;
      nomP := 'NombrePadre' + c;
      apeP := 'ApellidoPadre' + c;
    end;
    Str(i, c); // Convertir el número a string
    write(det, idet);
  end;
  close(det);
end;

procedure GenerarDatosFallecimiento(var det: detalle2);
var
  i: integer;
  idet: infoDetalle2;
  c: string; // Variable para almacenar el resultado de Str
begin
  rewrite(det);
  for i := 1 to CantidadRegistros do
  begin
    with idet do
    begin
      nro := i;
      mat := Random(1000); // Matrícula aleatoria del médico
      nom := 'Nombre' + c;
      ape := 'Apellido' + c;
      fecha := Random(31) + '/' + Random(12) + '/' + (Random(20) + 2000); // Fecha aleatoria desde el año 2000
      hora := Random(24) + ':' + Random(60); // Hora aleatoria
      lugar := 'Lugar' + c;
    end;
    Str(i, c); // Convertir el número a string
    write(det, idet);
  end;
  close(det);
end;

var
  detNacimiento: detalle1;
  detFallecimiento: detalle2;
  nombreArchivo: string;
  i: integer;
begin
  randomize; // Inicializa la secuencia de números aleatorios
  assign(detNacimiento, 'Nacimientos.dat');
  assign(detFallecimiento, 'Fallecimientos.dat');
  
  for i := 1 to 50 do
  begin
    Str(i, nombreArchivo);
    nombreArchivo := 'nacimiento' + nombreArchivo;
    assign(detNacimiento, nombreArchivo);
    rewrite(detNacimiento);
    GenerarDatosNacimiento(detNacimiento);
    close(detNacimiento);
    
    nombreArchivo := 'fallecimiento' + nombreArchivo;
    assign(detFallecimiento, nombreArchivo);
    rewrite(detFallecimiento);
    GenerarDatosFallecimiento(detFallecimiento);
    close(detFallecimiento);
  end;
end.
