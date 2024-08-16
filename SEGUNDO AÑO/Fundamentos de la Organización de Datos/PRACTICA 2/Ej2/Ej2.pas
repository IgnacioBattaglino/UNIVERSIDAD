program Pr2Ej2;
const 
  valorAlto = 9999;
type
  alumno = record
    cod, materiasSF, materiasCF: integer;
    ape, nom: string;
  end;

  materia = record
    alu: integer;
    info: string;
  end;

  alumnos = file of alumno;
  materias = file of materia;

procedure leerDetalle(var detalle: materias; var m: materia);
begin
  if not eof(detalle) then 
    read(detalle, m)
  else 
    m.alu := valorAlto;
end;

procedure leerMaestro(var maestro: alumnos; var a: alumno);
begin
  if not eof(maestro) then 
    read(maestro, a)
  else 
    a.cod := valorAlto;
end;

var 
  menu: integer;
  maestro: alumnos;
  detalle: materias;
  mat: materia;
  alu: alumno;
  texto:text;
  count: integer;
begin 
  writeln('Ingrese 1 para actualizar el archivo maestro', #10, 'Ingrese 2 para listar en un archivo de texto aquellos alumnos que tengan mas materias con finales aprobados que materias sin finales aprobados.');
  readln(menu);
  case menu of
    1: begin
         assign(maestro, 'MAESTRO');
         assign(detalle, 'DETALLE');
         reset(maestro);
         reset(detalle);
         while not eof(detalle) do begin
           leerDetalle(detalle, mat);
           while alu.cod <> mat.alu do 
             leerMaestro(maestro, alu);
           if mat.info = 'final' then begin 
             alu.materiasCF := alu.materiasCF + 1;
             alu.materiasSF := alu.materiasSF - 1;
           end
           else 
             alu.materiasSF := alu.materiasSF + 1;
           seek(maestro, filePos(maestro) - 1);
           write(maestro, alu);
         end;
         close (maestro);
         close (detalle);
       end;
    2: begin
          assign (texto, 'listado.txt');
          rewrite (texto);
          assign (maestro, 'MAESTRO');
          reset (maestro);
          while (not eof(maestro)) do begin
            leerMaestro (maestro,alu);
            if (alu.materiasCF>alu.materiasSF) then 
              writeln (texto, alu.ape, ' ', alu.nom, ' cod:', alu.cod, ' materias con final:', alu.materiasCF, ' materias sin final:', alu.materiasSF );
          end;
          close (maestro);
          close (texto);
       end;
    else 
      writeln('Numero no valido');
  end;
end.
