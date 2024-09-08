program ej2;

type 

arenteros= file of integer;

var
    enteros:arenteros;
    cantm,cant,sum:longint;
    archivo:string;
    aout:integer;
begin
    cantm:=0;
    cant:=0;
    sum:=0;
    writeln ('Ingrese el nombre del archivo a procesar');
    readln (archivo);
    assign (enteros, archivo);
    reset (enteros);
    read (enteros, aout);
    while (not eof(enteros)) do begin
        if (aout<1500) then cantm:=cantm+1;
        cant:=cant+1;
        sum:=sum+aout;
        read (enteros,aout);
    end;
    writeln ('El promedio de numeros es ', sum/cant:0:2);
    writeln ('La cantidad de numeros menores a 1500 es ', cantm);
end.
