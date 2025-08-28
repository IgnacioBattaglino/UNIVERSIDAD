program ej4;
type
    reg_flor = record
        nombre: String[45];
        codigo:integer;
    end;
    
    tArchFlores = file of reg_flor;

procedure leerFlor (var flor:reg_flor);
begin
    writeln ('Ingrese el codigo de la flor (-1 para terminar)');
    readln (flor.codigo);
    if (flor.codigo<>-1) then begin 
        writeln ('Ingrese el nombre de la flor');
        readln (flor.nombre);
    end;
end;

procedure crearArchivo (var arc:tArchFlores);
var
    flor:reg_flor;
begin
    rewrite (arc);
    flor.nombre:='';
    flor.codigo:=0;
    write (arc,flor);
    leerFlor (flor);
    while (flor.codigo<>-1) do begin
        write (arc,flor);
        leerFlor(flor);
    end;
    close (arc);
end;

procedure agregarFlor (var arc: tArchFlores ; nombre: string; codigo:integer);
var 
    aux,flor:reg_flor;
begin 
    reset (arc);
    read (arc,flor);
    aux.nombre:=nombre;
    aux.codigo:=codigo;
    if (flor.codigo<0) then begin
        seek (arc, abs(flor.codigo));
        read (arc,flor);
        seek (arc,filePos(arc)-1);
        write (arc,aux);
        seek (arc, 0);
        write (arc,flor);
    end
    else begin
        seek (arc, fileSize(arc));
        write (arc,aux);   
    end;
    close (arc);
end;

procedure eliminarFlor (var arc: tArchFlores; codigo:integer);
var 
    aux,flor:reg_flor;
    pos:integer;
begin
    reset (arc);
    flor.codigo:=-1;
    while (not eof (arc)) and (flor.codigo<>codigo) do 
        read (arc,flor);
    if (flor.codigo=codigo) then begin
        pos:= filepos(arc)-1;
        seek (arc, 0);
        read (arc, aux);
        seek (arc,0);
        flor.codigo:= flor.codigo * -1;
        write (arc,flor);
        seek (arc,pos);
        write (arc,aux);
    end
    else 
        writeln ('No se encontro la flor');
    close (arc);
end;

procedure listarContenido (var arc: tArchFlores);
var 
    flor:reg_flor;
begin
    reset (arc);
    while (not eof(arc)) do begin
        read (arc,flor);
        if (flor.codigo>0) then begin
            writeln ('Flor codigo: ', flor.codigo,' ........... nombre: ', flor.nombre);
            writeln ('..............................................');
        end;
    end;
    close (arc);
end;

var
    arc: tArchFlores;
begin
    assign (arc,'FLORES');
    crearArchivo (arc);
    listarContenido (arc);
    agregarFlor (arc, 'AGREGADA 1', 10);
    writeln ('---------------------------------------');
    listarContenido (arc);
    writeln ('---------------------------------------');
    eliminarFlor (arc, 3);
    listarContenido (arc);
    writeln ('---------------------------------------');
    agregarFlor (arc, 'AGREGADA 2', 20);
    listarContenido (arc);
    writeln ('---------------------------------------');
end.