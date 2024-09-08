program crearArchivos;
type

  infoDetalle=record
    cod:integer;
    fecha:string;
    tiempo:real;
  end;

  detalle= file of infoDetalle;

  var 
    det:detalle;
    texto:text;
    iDet:infoDetalle;
    i:integer;
    c:string;
    nombreArchivo:string;
begin
    for i:= 1 to 3 do begin 
        Str(i,c);
        nombreArchivo:= 'DETALLE' + c;
        assign (det, nombreArchivo);
        rewrite (det);
        nombreArchivo:= 'detalle' + c + '.txt';
        assign (texto, nombreArchivo);
        reset (texto);
        while (not eof(texto)) do begin 
            readln (texto, iDet.cod, iDet.tiempo,iDet.fecha);
            write (det,iDet);
        end;
        close (det);
        close (texto);
    end;
end.