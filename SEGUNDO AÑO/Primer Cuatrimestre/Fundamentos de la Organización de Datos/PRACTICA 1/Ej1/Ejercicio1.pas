program Ej1;
type

archivoint = file of integer; 

var 
    enteros:archivoint;
    ing:integer;
    arname:string;
begin
    writeln ('Ingrese el nombre del archivo a crear');
    readln (arname);
    assign (enteros, arname);
    rewrite (enteros);
    writeln ('Ingrese un numero');
    readln (ing);
    while (ing<>30000) do begin
        write (enteros,ing);
        writeln ('Ingrese un numero');
        readln (ing);
    end;
    close (enteros);
    reset (enteros);
    while (not eof(enteros)) do begin
        read (enteros, ing);
        writeln (ing);
    end;
end.