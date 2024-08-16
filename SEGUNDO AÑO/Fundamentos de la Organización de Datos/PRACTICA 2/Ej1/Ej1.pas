program ej1;
const 
valorAlto=9999;
type

empleado=record
    cod:integer;
    nombre:string;
    monto: real;
end;

archivo= file of empleado;

procedure imprimir (var a:archivo);
var e:empleado;
begin
    while (not eof(a)) do begin
        read (a,e);
        writeln (e.cod);
        writeln (e.monto:0:2);
        writeln ('-----------------')
    end;
end;


procedure leer (var detalle:archivo; var e:empleado);
begin
    if (not eof(detalle)) then 
        read (detalle,e)
    else 
        e.cod:= valorAlto;
end;

var 
e:empleado;
mon:real;
maestro:archivo;
detalle:archivo;
empact:empleado;

begin
    assign (maestro, 'MAESTRO');
    assign (detalle, 'DETALLE');
    rewrite (maestro);
    reset (detalle);
    imprimir (detalle);
    seek (detalle,0);
    leer (detalle,e);
    writeln(e.cod);
    while (e.cod<>valorAlto) do begin 
        empact:=e;
        mon:=0;
        while (empact.cod=e.cod) do begin
            mon:=mon+e.monto;
            leer (detalle,e);
        end;
        empact.monto:=mon;
        write (maestro,empact);
    end;
    close (maestro);
    close (detalle);
    assign (maestro, 'MAESTRO');
    reset (maestro);
    imprimir (maestro);
    close (maestro);
end.
