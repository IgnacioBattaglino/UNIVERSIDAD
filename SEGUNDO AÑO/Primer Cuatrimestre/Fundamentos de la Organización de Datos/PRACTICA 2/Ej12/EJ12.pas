program ej12;
const 
    valorAlto=9999;
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

procedure leerMae (var mae:maestro; var imae:infoMaestro);
begin 
    if (not eof(mae)) then 
        read (mae,imae)
    else 
        imae.nro_usuario:=valorAlto;
end;

procedure leerDet (var det:detalle; var idet:infoDetalle);
begin 
    if (not eof(det)) then
        read (det,idet)
    else 
        idet.nro_usuario:=valorAlto;
end;

procedure actualizarLog (var mae:maestro; var det:detalle);
var 
    imae:infoMaestro;
    idet:infoDetalle;
    cantmails,usact:integer;
begin 
    leerMae(mae,imae);
    leerDet (det,idet);
    while (idet.nro_usuario<>valorAlto) do begin 
        usact:=idet.nro_usuario;
        cantmails:=0;
        while (usact=idet.nro_usuario) do begin 
            leerDet (det,idet);
            cantmails:=cantmails+1;
        end;
        while (imae.nro_usuario<> usact) do
            leerMae(mae,imae);
        seek (mae,filepos(mae)-1);
        imae.cantMailEnviados:=imae.cantMailEnviados+cantmails;
        write (mae,imae);
    end;
end;

procedure generarArchivo (var mae:maestro; var texto:text);
var 
    imae:infoMaestro;
begin 
    leerMae(mae,imae);
    while (imae.nro_usuario<>valorAlto) do begin 
        writeln (texto, 'nro_usuario',imae.nro_usuario,'..........',imae.cantMailEnviados);
        leerMae(mae,imae);
    end;
end;

procedure actualizarygenerar (var mae:maestro; var det:detalle; var texto:text);
var 
    imae:infoMaestro;
    idet:infoDetalle;
    cantmails,usact:integer;
begin 
    leerMae(mae,imae);
    leerDet (det,idet);
    while (idet.nro_usuario<>valorAlto) do begin 
        usact:=idet.nro_usuario;
        cantmails:=0;
        while (usact=idet.nro_usuario) do begin 
            leerDet (det,idet);
            cantmails:=cantmails+1;
        end;
        while (imae.nro_usuario<> usact) do begin
            leerMae(mae,imae);
            if (imae.nro_usuario<> usact) then
                writeln (texto, 'nro_usuario',imae.nro_usuario,'..........',imae.cantMailEnviados);
        end;
        seek (mae,filepos(mae)-1);
        imae.cantMailEnviados:=imae.cantMailEnviados+cantmails;
        writeln (texto, 'nro_usuario',imae.nro_usuario,'..........',imae.cantMailEnviados);
        write (mae,imae);
    end;
end;

var 
    mae:maestro;
    det:detalle;
    texto:text;
begin
    assign (mae, 'MAESTRO');
    reset (mae);
    assign (det,'DETALLE');
    reset (det);
    //actualizarLog (mae,det);
    assign (texto, 'informe.txt');
    rewrite (texto);
    //seek (mae, 0);
    //generarArchivo (mae,texto);
    actualizarygenerar (mae,det,texto);
    close (det);
    close (mae);
    close (texto);
end.