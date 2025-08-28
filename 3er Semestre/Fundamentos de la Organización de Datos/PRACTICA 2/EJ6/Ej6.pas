program ej6;
const 
  valorAlto=9999;
  dimf=3;
type 
  subrango = 1 .. dimF;

  infoDetalle=record
    cod:integer;
    fecha:string;
    tiempo:real;
  end;

  detalle= file of infoDetalle;
  maestro= file of infoDetalle;
  vecDet= array [subrango] of detalle;
  vecReg= array [subrango] of infoDetalle;

procedure leer(var det: detalle; var dato: infoDetalle);
begin
  if(not eof(det)) then
      read(det, dato)
  else
      dato.cod:= valoralto;  
end;    

procedure minimo (var ar:vecDet; var reg: vecReg; var min: infoDetalle);
var 
  i,pos:subrango;
begin
  min.cod:=valorAlto;
  for i:=1 to dimF do 
    if (reg[i].cod<min.cod) then begin
      min:= reg[i]; 
      pos:=i;
    end;
  if (min.cod<>valorAlto) then 
    leer (ar[pos],reg[pos]);
end;

procedure imprimirMaestro(var mae: maestro);
var
    s: infoDetalle;
begin
    reset(mae);
    while(not eof(mae)) do
        begin
            read(mae, s);
            writeln('Codigo=', s.cod, ' Fecha=', s.fecha, ' Tiempo=', s.tiempo:0:2);
        end;
    close(mae);
end;

var 
  vDet: vecDet;
  vReg: vecReg;
  i:subrango;
  nombreArchivo,c:string;
  act,min:infoDetalle;
  mae:maestro;
begin 
  
  for i:= 1 to dimF do begin
    Str (i,c);
    nombreArchivo:= 'DETALLE' + c;
    assign (vDet[i],nombreArchivo);
    reset (vDet[i]);
    leer (vDet[i],vReg[i]);
  end;
  
  assign (mae, 'MAESTRO');
  rewrite (mae);
  minimo (vDet,vReg,min);
  
  while (min.cod<>valorAlto) do begin 
    act.cod:=min.cod;
    while (act.cod=min.cod) do begin
      act.fecha:=min.fecha; 
      act.tiempo:=0;
      while (act.cod=min.cod) and (act.fecha=min.fecha) do begin 
        act.tiempo:=act.tiempo + min.tiempo;
        minimo (vDet,vReg,min);
      end;
      write (mae,act);
    end;
  end;
  for i:= 1 to dimF do 
    close (vDet[i]);
  close (mae);

  imprimirMaestro (mae);
end.
