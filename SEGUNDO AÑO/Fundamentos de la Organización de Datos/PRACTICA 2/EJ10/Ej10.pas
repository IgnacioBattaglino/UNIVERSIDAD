program ej10;
const 
    valorAlto=9999;
type
    infoMaestro = record
        dep, divi, num,cat,cant: integer;
    end;

    maestro = file of infoMaestro;

    montos= array [1..15] of real;


procedure leer (var archivo: maestro; var dato:infoMaestro);
begin 
    if (not eof(archivo)) then
        read (archivo,dato)
    else 
        dato.dep:=valorAlto;
end;

procedure cargarAreglo (var importes:montos);
var 
texto:text;
i:integer;    
mon:real;
begin
    assign (texto,'montos.txt');
    reset (texto);
    for i:=1 to 15 do begin 
        read (texto, mon);
        importes[i]:=mon;
    end;
    close (texto);
end;

procedure obtener_reporte(var archivo: maestro; var importes:montos);
var 
    dato:infoMaestro;
    depact,divact,numact,tothorasdiv,tothorasdep,cant:integer;
    monto,totmontodiv,totmontodep:real;
begin
    leer (archivo,dato);
    while (dato.dep<>valorAlto) do begin
        depact:=dato.dep;
        totmontodep:=0;
        tothorasdep:=0;
        writeln ('Departamento: ', depact);
        while (dato.dep<>valorAlto) and (depact=dato.dep) do begin 
            divact:=dato.divi;
            writeln ('Division: ', divact);
            writeln ('Numero de Empleado:     Total de horas:      Importe a cobrar:    ');
            tothorasdiv:=0;
            totmontodiv:=0;
            while (dato.dep<>valorAlto) and (depact=dato.dep) and (divact=dato.divi) do begin 
                numact:=dato.num;
                cant:=0;
                monto:=0;
                while (dato.dep<>valorAlto) and (depact=dato.dep) and (divact=dato.divi) and (numact=dato.num) do begin
                    cant:= cant+ dato.cant;
                    monto:=monto + dato.cant*importes[dato.cat];
                    leer (archivo,dato)
                end;
                tothorasdiv:= tothorasdiv+cant;
                totmontodiv:= totmontodiv+monto;
                writeln ('                    ',numact,'                   ', cant,'                    ', monto:0:2);
            end;
            writeln ('Total de horas division: ', tothorasdiv);
            writeln ('Monto total por division: ', totmontodiv:0:2);
            tothorasdep:=tothorasdep+tothorasdiv;
            totmontodep:=totmontodep+totmontodiv;
        end;
        writeln ('Total de horas departamento: ', tothorasdep);
        writeln ('Monto total departamento: ', totmontodep:0:2);
    end;
end;

var 
arreglo:montos;
mae:maestro;

begin
    assign (mae,'MAESTRO');
    reset (mae);
    cargarAreglo (arreglo);
    obtener_reporte(mae,arreglo);
    close (mae);
    writeln ('FIN DEL PROGRAMA');
end.