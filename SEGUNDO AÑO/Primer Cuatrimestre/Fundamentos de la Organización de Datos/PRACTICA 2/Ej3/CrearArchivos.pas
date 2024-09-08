program crearArchivo;
type
    producto=record
        cod,stockAct,StockMin,pre: integer;
        nom:string;
    end;

    venta=record
        cant,cod:integer;
    end;

    productos= file of producto;
    ventas= file of venta;

procedure imprimir (var a:productos);
    var p:producto;
    begin
        while (not eof(a)) do begin
            read (a,p);
            writeln (p.nom);
            writeln (p.cod);
            writeln (p.stockAct);
            writeln (p.StockMin);
            writeln (p.pre);
            writeln ('-----------------')
        end;
    end;

procedure imprimir2 (var a:ventas);
    var v:venta;
    begin
        while (not eof(a)) do begin
            read (a,v);
            writeln (v.cod);
            writeln (v.cant);
            writeln ('-----------------')
        end;
    end;

var 
archivotxt: text;
prod:producto;
ven:venta;
maestro:productos;
menu:integer;

detalle:ventas;

begin
    writeln ('Ingrese 1 para crear archivo maestro, ingrese 2 para crear archivo detalle');
    readln (menu);
    case menu of
    1:  begin
            assign (maestro,'MAESTRO');
            writeln ('Abriendo archivo maestro...');
            rewrite (maestro);
            assign (archivotxt, 'maestro.txt');
            writeln ('Abriendo archivo maestro.txt...');
            reset(archivotxt);
            while not eof(archivotxt) do begin 
                writeln ('Leyendo datos del archivo maestro.txt...');
                readln (archivotxt, prod.cod, prod.pre, prod.stockAct, prod.StockMin);
                readln (archivotxt, prod.nom);
                writeln ('Escribiendo en archivo maestro...');
                write(maestro,prod);
            end;
            writeln ('Cerrando archivo maestro.txt...');
            close (archivotxt);
            writeln ('Cerrando archivo maestro...');
            close (maestro);
            reset (maestro);
            imprimir (maestro);
            close (maestro);
        end;
    2:  begin  
            assign (detalle,'DETALLE');
            writeln ('Abriendo archivo detalle...');
            rewrite (detalle);
            assign (archivotxt, 'detalle.txt');
            writeln ('Abriendo archivo detalle.txt...');
            reset(archivotxt);
            while (not eof(archivotxt)) do begin 
                writeln ('Leyendo datos del archivo detalle.txt...');
                readln (archivotxt, ven.cod, ven.cant); 
                writeln ('Escribiendo en archivo detalle...');
                write (detalle, ven);
            end;
            writeln ('Cerrando archivo detalle.txt...');
            close (archivotxt);
            writeln ('Cerrando archivo detalle...');
            close (detalle);
            reset (detalle);
            imprimir2 (detalle);
            close (detalle);
        end;
    else begin
        writeln ('Numero no valido');
    end;
end;
    
end.
