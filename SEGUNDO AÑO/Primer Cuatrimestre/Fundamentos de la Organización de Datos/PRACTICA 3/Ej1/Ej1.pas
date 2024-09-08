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

procedure agregaralarchivo (r:empleado);
var aux:empleado;
begin 
    aux.num:= -1;
    while (not eof(empleados)) and (aux.num<>r.num) do begin 
        read (empleados,aux);
    end;
    if (aux.num=r.num) then 
        writeln ('Empleado ya cargado')
    else 
        write (empleados,r);
end;

procedure modificarEdad (num,edad:integer);
var r:empleado;
begin 
    r.num:=-1;
    assign (empleados, 'prueba2');
    reset (empleados);
    while (not eof(empleados)) and (r.num<>num) do begin 
        read (empleados,r);
    end;
    if (r.num=num) then begin 
        r.edad:=edad;
        seek (empleados,filepos(empleados)-1);
        write (empleados,r) 
    end
    else 
        writeln ('no se encontro ese empleado');
end;

procedure eliminarEmpleado ();
var
eli:integer;
ultEmpleado,e:empleado;
begin
    writeln ('Ingrese el numero del empleado a eliminar');
    readln (eli);
    seek (empleados, fileSize(empleados)-1);

    read (empleados,ultEmpleado);

    seek (empleados,0);

    read (empleados,e);
 
    while (not eof(empleados)) and (e.num<>eli) do
        read (empleados,e);
    if (e.num=eli) then begin 
        seek (empleados,filePos(empleados)-1);
        write (empleados,ultEmpleado);
        seek (empleados,fileSize(empleados)-1);
        truncate (empleados);
        writeln ('Empleado borrado con exito');
    end
    else 
        writeln ('No se encontro el empleado');
end;

var
auxS:string;
auxI2:integer;
auxI:shortint;
r:empleado;
nom,ape:string;
arch:Text;

begin
    writeln ('Ingrese 1 para crear un archivo de empleados', #13+#10 ,'Ingrese 2 para abrir el archivo generado y leerlo ', #13+#10 ,'Ingrese 3 para añadir empleados al final del archivo', #13+#10 ,'Ingrese 4 para modificar la edad de un empleado dado.', #13+#10 ,'Ingrese 5 para exportar el contenido del archivo a un archivo de texto llamado "todos_empleados.txt"', #13+#10 ,'Ingrese 6 para exportar a un archivo de texto llamado "faltaDNIEmpleado.txt", los empleados que no tengan cargado el DNI (DNI en 00).');
    readln (auxI);
    case auxI of 
    1:  begin
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
    end;
    2:  begin
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
    close (empleados) 
    end;
    3: begin  
        r.ape:='aa';
        assign (empleados, 'prueba2');
        reset (empleados);
        while (r.ape<>'fin') do begin 
            writeln ('Ingrese los datos del empleado que quiere agregar: ');
            writeln ('Apellido:');
            readln (r.ape);
            if (r.ape<>'fin') then begin 
                writeln ('Nombre:');
                readln (r.nom);
                writeln ('Edad:');
                readln (r.edad);
                writeln ('Num de empleado:');
                readln (r.num);
                writeln ('DNI:');
                readln (r.dni);
                agregaralarchivo (r);
            end;
        end;
        close (empleados);
    end;
    4: begin 
        writeln ('Ingrese el num del empleado a modificarle la edad');
        readln (auxI2);
        writeln ('Ingrese la nueva edad');
        readln (auxI);
        modificarEdad(auxI2,auxI);
    end; 
    5: begin  
        assign (empleados, 'prueba2');
        reset (empleados);
        assign (arch,'todos_empleados.txt');
        rewrite (arch);
        while (not eof(empleados)) do begin 
            read (empleados, r);
            with r do begin 
                writeln (arch,num);
                writeln (arch,edad);
                writeln (arch,dni); 
                writeln (arch,ape);
                writeln (arch,nom);
            end;
        end;
        close (arch);
        close (empleados);
    end;
    6: begin 
        assign (empleados, 'prueba2');
        reset (empleados);
        assign (arch,'faltaDNIEmpleado.txt');
        rewrite (arch);
        while (not eof(empleados)) do begin 
            read (empleados, r);
            if (r.dni=0) then begin 
                with r do begin 
                    writeln (arch,num);
                    writeln (arch,edad);
                    writeln (arch,dni); 
                    writeln (arch,ape);
                    writeln (arch,nom);
                end;
            end; 
        end;
        close (arch);
        close (empleados);
    end;
    else begin 
        writeln ('Opcion ingresada no valida.');
    end;
    end;
    assign (empleados, 'prueba2');
    reset (empleados);
    eliminarEmpleado();
    close (empleados);
end.

