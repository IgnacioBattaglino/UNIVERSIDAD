program crearArchivo;
type
    alumno=record
        cod,materiasSF,materiasCF: integer;
        ape,nom:string;
    end;

    materia=record
        alu:integer;
        info: string;
    end;

    bin= file of alumno;
    bin2= file of materia;

procedure imprimir (var a:bin);
    var alu:alumno;
    begin
        while (not eof(a)) do begin
            read (a,alu);
            writeln (alu.cod);
            writeln (alu.nom);
            writeln (alu.materiasCF);
            writeln (alu.materiasSF);
            writeln ('-----------------')
        end;
    end;

procedure imprimir2 (var a:bin2);
    var mat:materia;
    begin
        while (not eof(a)) do begin
            read (a,mat);
            writeln (mat.alu);
            writeln (mat.info);
            writeln ('-----------------')
        end;
    end;

var 
archivotxt: text;
alu:alumno;
mat:materia;
archivobin:bin;
aux:integer;
nom:string;
archivobin2:bin2;

begin
 
    writeln ('Ingrese 1 para crear archivo maestro, ingrese 2 para crear archivo detalle');
    readln (aux);
    if (aux=1) then begin  
        writeln ('Ingrese el nombre que le quiere dar a su archivo');
        readln (nom);
        assign (archivobin,nom);
        rewrite (archivobin);
        writeln ('Ingrese el nombre del archivo txt del que se leeran los datos');
        readln (nom);
        assign (archivotxt, nom);
        reset(archivotxt);
        while (not eof(archivotxt)) do begin 
            readln (archivotxt, alu.cod, alu.materiasCF, alu.materiasSF);
            readln (archivotxt); 
            readln (archivotxt, alu.ape);
            readln (archivotxt, alu.nom);
            write (archivobin, alu);
        end;
        close (archivotxt);
        close (archivobin);
    end
    else begin 
        writeln ('Ingrese el nombre que le quiere dar a su archivo');
        readln (nom);
        assign (archivobin2,nom);
        rewrite (archivobin2);
        writeln ('Ingrese el nombre del archivo txt del que se leeran los datos');
        readln (nom);
        assign (archivotxt, nom);
        reset(archivotxt);
        while (not eof(archivotxt)) do begin 
            // Leer el número entero y la cadena de texto en líneas separadas
            readln (archivotxt, mat.alu); 
            read (archivotxt, mat.info);
            write (archivobin2, mat);
        end;
        close (archivotxt);
    end;
    seek (archivobin2,0);
    imprimir2 (archivobin2);
    close (archivobin2);
    *)
    assign (archivobin,'MAESTRO');
    reset (archivobin);
    imprimir (archivobin);
end.