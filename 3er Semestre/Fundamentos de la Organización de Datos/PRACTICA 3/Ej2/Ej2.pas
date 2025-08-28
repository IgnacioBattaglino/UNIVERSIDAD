program ej2;
type
    asistente=record
        nro,dni:integer;
        nom,ape,email:string;
    end;

    asistentes= file of asistente;

procedure crearArchivo (var a:asistentes);
var 
    asis:asistente;
begin 
    asis.nro:=9999;
    rewrite(a);
    while (asis.nro<>-1) do begin 
        writeln ('Ingrese el nro del asistente (-1 para terminar)');
        readln (asis.nro);
        if (asis.nro<>-1) then begin
            writeln ('Ingrese el nombre del asistente');
            readln (asis.nom);
            writeln ('Ingrese el apellido del asistente');
            readln (asis.ape); 
            writeln ('Ingrese el email del asistente');
            readln (asis.email);
            writeln ('Ingrese el dni del asistente');
            readln (asis.email);
            write (a,asis);
        end;  
    end;
    close (a);
end;

procedure eliminarInferiores (var a:asistentes);
var
    asis:asistente;
begin 
    reset (a);
    while (not eof(a)) do begin 
        read (a,asis);
        if (asis.nro<1000) then begin 
            asis.nom:= '@' + asis.nom;
            seek (a,filePos(a)-1);
            write (a,asis);
        end;
    end;
    close (a);
end;

procedure imprimirArchivo (var a:asistentes);
var
    asis:asistente;
begin 
    reset (a);
    while (not eof(a)) do begin
        read (a,asis);
        writeln (asis.nom);
        writeln ('--------');
    end;
    close (a);
end;

var
arc:asistentes;

begin
    assign (arc, 'Archivo');
    crearArchivo(arc);
    eliminarInferiores (arc);
    imprimirArchivo (arc);
end.