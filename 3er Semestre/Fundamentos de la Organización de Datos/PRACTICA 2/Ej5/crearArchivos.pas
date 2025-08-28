program crearArchivos;
type
    producto=record
        cod,stockDis,stockMin,pre:integer;
        nombre,des:string;
    end;
    venta=record
        cod,cant:integer;
    end;

    maestro=file of producto;
    detalle=file of venta;

var 
    mae:maestro;
    det:detalle;
    texto:text;
    prod:producto;
    ven:venta;
    i:integer;
    c:string;
    nombreArchivo:string;
begin
    assign (mae, 'MAESTRO');
    rewrite (mae);
    assign (texto, 'maestro.txt');
    reset (texto);
    while (not eof(texto)) do begin 
        readln (texto, prod.cod, prod.stockDis, prod.stockMin, prod.pre, prod.nombre);
        readln (texto, prod.des);
        write (mae,prod);
    end;
    close (mae);
    for i:= 1 to 4 do begin 
        Str(i,c);
        nombreArchivo:= 'DETALLE' + c;
        assign (det, nombreArchivo);
        rewrite (det);
        nombreArchivo:= 'detalle' + c + '.txt';
        assign (texto, nombreArchivo);
        reset (texto);
        while (not eof(texto)) do begin 
            readln (texto, ven.cod, ven.cant);
            write (det,ven);
        end;
        close (det);
        close (texto);
    end;
end.