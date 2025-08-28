program crearArchivo;
type
    infoMaestro=record
        nro_usuario,cantMailEnviados: integer;
        nombreUsuario,nombre,apellido:string;
    end;

    infoDetalle=record
        nro_usuario,cuentaDestino:integer;
        cuerpoMensaje:string;
    end;

    detalle= file of infoDetalle;
    maestro= file of infoMaestro;

var 
archivotxt: text;
mae:maestro;
det:detalle;
imae:infoMaestro;
idet:infoDetalle;
begin
    assign (archivotxt,'maestro.txt');
    assign (mae,'MAESTRO');
    rewrite (mae);
    reset (archivotxt);
    with imae do begin
        while (not eof(archivotxt)) do begin 
            readln (archivotxt,nro_usuario,cantMailEnviados,nombreUsuario);
            readln (archivotxt,nombre);
            readln (archivotxt,apellido);
            write (mae,imae);
        end;
    end;
    close (mae);
    assign (archivotxt,'detalle.txt');
    reset (archivotxt);
    assign (det,'DETALLE');
    rewrite (det);
    with idet do begin
        while (not eof(archivotxt)) do begin 
            read (archivotxt,nro_usuario,cuentaDestino,cuerpoMensaje);
            write (det,idet)
        end;
    end;
    close (det);
    close (archivotxt);
end.