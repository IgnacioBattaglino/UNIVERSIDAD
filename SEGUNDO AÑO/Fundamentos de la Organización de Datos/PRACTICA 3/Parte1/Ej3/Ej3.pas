program ej3;
type
    novela=record 
        cod,duracion:integer;
        nom,genero,dir:string;
        pre:real;
    end;

    novelas= file of novela;

procedure crearArchivo (var arc:novelas);
var 
    nov:novela;
begin 
    rewrite(arc);
    nov.cod:=0;
    nov.genero:='';
    nov.dir:='';
    nov.nom:='';
    nov.duracion:=0;
    nov.pre:=0;
    write (arc,nov);
    while (nov.cod<>-1) do begin 
        writeln ('Ingrese el codigo de la novela (-1 para terminar)');
        readln (nov.cod);
        if (nov.cod<>-1) then begin
            writeln ('Ingrese el genero de la novela');
            readln (nov.genero);
            writeln ('Ingrese el nombre del director');
            readln (nov.dir); 
            writeln ('Ingrese el nombre de la novela');
            readln (nov.nom);
            writeln ('Ingrese la duracion de la novela');
            readln (nov.duracion);
            writeln ('Ingrese el precio de la novela');
            readln (nov.pre);
            write (arc,nov);
        end;  
    end;
    close (arc);
end;

procedure darAlta (var arc:novelas);
var 
n,nov:novela;
pos:integer;
begin
    reset (arc);
    writeln ('Ingrese el codigo de la novela');
    readln (nov.cod);
    writeln ('Ingrese el genero de la novela');
    readln (nov.genero);
    writeln ('Ingrese el nombre del director');
    readln (nov.dir); 
    writeln ('Ingrese el nombre de la novela');
    readln (nov.nom);
    writeln ('Ingrese la duracion de la novela');
    readln (nov.duracion);
    writeln ('Ingrese el precio de la novela');
    readln (nov.pre);
    read (arc,n);
    if (n.cod>=0) then begin  
        seek (arc,fileSize(arc));
        write (arc,nov);
    end
    else begin
        pos:=abs(n.cod);
        seek (arc,pos-1);
        read (arc,n);
        seek (arc,0);
        write (arc,n);
        seek (arc,pos-1);
        write (arc,nov);
    end;
    close (arc);
end;

procedure modificarNovela (var arc:novelas);
var 
    nov:novela;
    cod:integer;
begin
    reset (arc);
    writeln ('Ingrese el codigo de la novela que quiere modificar');
    readln (cod);
    nov.cod:=-1;
    while (not eof (arc)) and (nov.cod<>cod) do 
        read (arc,nov);
    if (nov.cod=cod) then begin
        writeln ('Ingrese los nuevos datos: ');
        writeln ('Ingrese el genero de la novela');
        readln (nov.genero);
        writeln ('Ingrese el nombre del director');
        readln (nov.dir); 
        writeln ('Ingrese el nombre de la novela');
        readln (nov.nom);
        writeln ('Ingrese la duracion de la novela');
        readln (nov.duracion);
        writeln ('Ingrese el precio de la novela');
        readln (nov.pre);
        seek (arc,filePos(arc)-1);
        write (arc,nov);
    end
    else 
        writeln ('La novela no existe');
    close (arc);
end;

procedure darBaja (var arc:novelas);
var
    pos,cod:integer;
    aux,nov:novela;
begin
    reset (arc);
    read (arc,aux);
    writeln ('Ingrese el codigo de la novela que quiere eliminar');
    readln (cod);
    nov.cod:=-1;
    while (not eof (arc)) and (nov.cod<>cod) do 
        read (arc,nov);
    if (nov.cod=cod) then begin
        pos:= filePos(arc);
        seek (arc, pos-1);
        write (arc,aux);
        nov.cod:= pos *-1;
        seek (arc,0);
        write (arc,nov);   
    end
    else 
        writeln ('No existe esa novela');
    close (arc);
end;

procedure listarNovelas (var arc:novelas);
var 
    texto:text;
    nov:novela;
begin  
    reset (arc);
    assign (texto, 'novelas.txt');
    rewrite (texto);
    while (not eof(arc)) do begin
        read (arc,nov);
        writeln (texto, nov.cod, ' ............. ', nov.nom);
    end;
    close (arc);
    close (texto);
end;

var 
    menu:integer;
    arc:novelas;
begin
    assign (arc, 'NOVELAS');
    menu:=0;
    while (menu<>6) do begin 
        writeln ('Ingrese 1 para crear el archivo y cargarlo a partir de datos ingresados por teclado');
        writeln ('Ingrese 2 para dar de alta una novela');
        writeln ('Ingrese 3 para modificar los datos de una novela');
        writeln ('Ingrese 4 para dar de baja una novela');
        writeln ('Ingrese 5 para listar en un archivo de texto todas las novelas');
        writeln ('Ingrese 6 para salir');
        readln (menu);
        case menu of
        1:
            crearArchivo (arc);
        2:
            darAlta(arc);
        3:
            modificarNovela(arc);
        4:
            darBaja(arc);
        5:
            listarNovelas (arc);
        end;
    end;

end.