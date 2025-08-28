program ej3;

type
empleado=record
    num:integer;
    ape:string[20];
    nom:string[15];
    edad:shortint;
    dni: longint;
end;

fempleados = file of empleado;

var 
empleados:fempleados;

procedure imprimirarchivo ();
var 
r:empleado;
begin
    while (not eof(empleados)) do begin
        read (empleados,r);
        writeln ('Empleado num: ', r.num,' Nombre: ', r.ape, ' ', r.nom );
    end;
end;

function buscarrecord (a,n:string ): empleado;
var 
raux:empleado;
begin
    if (not eof(empleados)) then begin
        read (empleados, raux);
        while (not eof(empleados)) and (raux.ape<>a) and (raux.nom<>n) do begin
            read (empleados, raux);
        end;
        if (raux.ape=a) and (raux.nom=n) then 
            buscarrecord:= raux 
        else begin
            raux.ape:= 'notfound';
            buscarrecord:= raux; 
        end;
    end
    else 
        raux.ape:= 'notfound';
        buscarrecord:= raux; 
end;

procedure imprimirrecord (r:empleado);
begin
    if (r.ape= 'notfound') then 
        writeln ('Empleado no existente')
    else begin 
        writeln ('Datos del empleado ', r.ape, ' ', r.nom, ':');
        writeln ('Num de empleado: ', r.num);
        writeln ('Edad: ',r.edad , ' años');
        writeln ('DNI: ', r.dni);
    end;
end;

procedure imprimirmayores ();
var
r:empleado;
begin
    writeln ('Empleados mayores de 70 años:');
    while (not eof(empleados)) do begin
        read (empleados,r);
        if (r.edad>=70) then 
            writeln ('Empleado num: ', r.num,' Nombre: ', r.ape, ' ', r.nom );
    end;
end;

var
auxS:string;
auxI:shortint;
r:empleado;
nom,ape:string;

begin
    writeln ('Ingrese 1 para crear un archivo de empleados', #13+#10 ,'Ingrese 2 para abrir el archivo generado y leerlo ');
    readln (auxI);
    if (auxI=1) then begin
        writeln ('Ingrese el nombre que quiere darle al archivo.');
        readln (auxS);
        assign (empleados, auxS); 
        rewrite (empleados);
        r.ape:='xx';
        while (r.ape<>'fin') do begin
            writeln ('Ingrese el apellido del empleado');
            readln (r.ape);
            if (r.ape<>'fin') then begin
                writeln ('Ingrese el nombre del empleado');
                readln (r.nom);
                writeln ('Ingrese el num de empleado');
                readln (r.num);
                writeln ('Ingrese la edad del empleado');
                readln (r.edad);
                writeln ('Ingrese el dni del empleado');
                readln (r.dni); 
                write (empleados,r);
            end;
        end;
        close (empleados);
    end
    else begin
        assign (empleados, 'prueba2');
        reset (empleados);
        writeln ('Escriba 1 para listar en pantalla los datos de los empleados que tengan un nombre y apellido determinado, para terminar ingrese el apellido xx',#13+#10,'Escriba 2 para listar todos los empleados', #13+#10 ,'Escriba 3 para listar los empleados mayores a 70' );
        readln (auxI);
        if (auxI=1) then begin
            ape:=' ';
            while (ape<>'xx') do begin 
                writeln ('Ingrese el apellido del empleado.');
                readln (ape);
                if (ape<> 'xx') then begin 
                    writeln ('Ingrese el nombre del empleado');
                    readln (nom);
                    seek (empleados, 0);
                    imprimirrecord (buscarrecord (ape,nom));
                end;
            end;
        end
        else if (auxI=2) then begin 
            imprimirarchivo();
        end
        else begin
            imprimirmayores();
        end; 
    end; 

end.
