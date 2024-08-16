program ej18;
const 
    valorAlto=9999;
type
    direccion=record    
        calle,nro,piso,dto:integer;
        ciudad:string;
    end;

    infoMaestro=record
        nro,matN,matF:integer;
        dir:direccion;
        nom,ape,nomM,apeM,dni,dniM,dniP,nomP,apeP,fecha,hora,lugar:string;
    end;

    infoDetalle1=record
        nro,mat:integer;
        dir:direccion;
        nom,ape,nomM,apeM,dni,dniM,dniP,nomP,apeP:string;
    end;

    infoDetalle2=record
        nro,mat:integer;
        nom,ape,fecha,hora,lugar:string;
    end;

    detalle1= file of infoDetalle1;
    detalle2= file of infoDetalle2;
    maestro= file of infoMaestro;
    
    nacimientos= array [1..50] of detalle1;
    fallecimientos= array [1..50] of detalle2;

procedure leer1 (var det:detalle1; var idet:infoDetalle1);
begin 
    if (not eof(det)) then
        read (det,idet)
    else 
        idet.nro:=valorAlto;
end;

procedure leer2 (var det:detalle2; var idet:infoDetalle2);
begin 
    if (not eof(det)) then
        read (det,idet)
    else 
        idet.nro:=valorAlto;
end;

procedure actualizarMaestro (var nac:detalle1; var falle:detalle2; var mae:maestro; var texto:text);
var
    imae:infoMaestro;
    inac:infoDetalle1;
    ifal:infoDetalle2;
begin 
    leer1(nac,inac);
    leer2 (falle,ifal);
    while (inac.nro<>valorAlto) do begin
        imae.nro:= inac.nro;
        imae.dir:= inac.dir;
        imae.nom:= inac.nom;
        imae.dni:= inac.dni;
        imae.ape:= inac.ape;
        imae.nomM:= inac.nomM;
        imae.nomP:= inac.nomP;
        imae.apeM:= inac.apeM;
        imae.apeP:= inac.apeP;
        imae.dniM:= inac.dniM;
        imae.dniP:= inac.dniP;
        if (ifal.nro= imae.nro) then begin
            imae.fecha:= ifal.fecha;
            imae.hora:= ifal.hora;
            imae.lugar:= ifal.lugar;
            leer2(falle,ifal);
        end
        else begin 
            imae.fecha:= '-';
            imae.hora:= '-';
            imae.lugar:= '-';
        end;
        writeln (texto, 'Nombre: ',imae.nom,' ',imae.ape,'DNI: ',imae.dni, 'Direccion: ', imae.dir);
        write (mae,imae);
        leer1(nac,inac);
    end;
end;

var 
    mae:maestro;
    nac:nacimientos;
    falle:fallecimientos;
    texto:text;
    nombreArchivo,c:string;
    i:integer;
begin
    assign (mae, 'MAESTRO');
    reset (mae);
    assign (texto, 'informe.txt');
    rewrite (texto);

    for i:= 1 to 50 do begin 
        Str (i,c);
        nombreArchivo:= 'nacimiento' + c;
        assign (nac[i],nombreArchivo);
        nombreArchivo:= 'fallecimiento' + c;
        assign (falle[i],nombreArchivo);
        rewrite (nac[i]);
        rewrite (falle[i]);
        actualizarMaestro (nac[i],falle[i],mae,texto);
        close (falle[i]);
        close (nac[i]);
    end;
    close (mae);
    close (texto);
end.