program pr2ej4;
const
    valoralto = 'ZZZ';

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

var
  mae:maestro;
  det1:detalle;
  det2:detalle;

procedure leer(var det: detalle; var dato: infoDetalle);
  begin
    if(not eof(det)) then
        read(det, dato)
    else
        dato.nombre:= valoralto;  
  end;    

procedure minimo (var r1, r2, min: infoDetalle);
  begin
    if (r1.nombre<=r2.nombre) then begin
      min:= r1; 
      leer (det1, r1)
    end
    else begin 
      min:=r2;
      leer (det2,r2);
    end; 
  end;

procedure imprimirMaestro(var mae: maestro);
var
    infoMae: infoMaestro;
begin
    reset(mae);
    while(not eof(mae)) do
        begin
            read(mae, infoMae);
            with infoMae do
                writeln('Nombre=', nombre, ' Alfabetizados=', alfabetizados, ' Encuestados=', encuestados);
        end;
    close(mae);
end;

var 
reg1, reg2, min: infoDetalle;
regm:infoMaestro;

begin
  assign (mae, 'MAESTRO');
  assign (det1, 'DETALLE1');
  assign (det2, 'DETALLE2');
  reset (mae);
  reset (det1);
  reset (det2);
  leer (det1,reg1);
  leer (det2,reg2);
  minimo (reg1,reg2,min);
  while (min.nombre<>valoralto) do begin 
    read (mae, regm);
    while (regm.nombre<>min.nombre) do
      read (mae,regm);
    while (regm.nombre=min.nombre) do begin 
      regm.alfabetizados:= regm.alfabetizados+ min.alfabetizados;
      regm.encuestados:= regm.encuestados + min.encuestados;
      minimo (reg1,reg2,min);
    end;
    seek (mae, filepos(mae)-1);
    write (mae,regm);
  end;
  close (mae);
  close (det1);
  close (det2);
  imprimirMaestro (mae);
end.