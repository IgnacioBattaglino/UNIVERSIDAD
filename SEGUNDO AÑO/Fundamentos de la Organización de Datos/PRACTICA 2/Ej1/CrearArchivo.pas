program creararchivo;

type

empleado=record
    cod:integer;
    nombre:string;
    monto: real;
end;

archivo= file of empleado;

var 
e:empleado;
archi:archivo;
begin
    assign (archi,'DETALLE');
    rewrite (archi);
    repeat 
        writeln ('cod=');
        readln (e.cod);
        if (e.cod<>-1) then begin 
            writeln ('nom=');
            readln (e.nombre);
            writeln ('monto=');
            readln (e.monto);
            write (archi,e);
        end;
    until (e.cod=-1);
    close (archi); 
end.