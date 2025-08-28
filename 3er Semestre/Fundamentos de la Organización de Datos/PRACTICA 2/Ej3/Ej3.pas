program Pr2Ej2;
const 
  valorAlto = 9999;
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


procedure leerDetalle(var detalle: ventas; var v: venta);
begin
  if not eof(detalle) then 
    read(detalle, v)
  else 
    v.cod := valorAlto;
end;

procedure leerMaestro(var maestro: productos; var p: producto);
begin
  if not eof(maestro) then 
    read(maestro, p)
  else 
    p.cod := valorAlto;
end;

var 
  menu: integer;
  maestro: productos;
  detalle: ventas;
  ven: venta;
  prod: producto;
  texto:text;

begin 
  writeln('Ingrese 1 para actualizar el archivo maestro', #10, 'Ingrese 2 para listar en un archivo de texto llamado “stock_minimo.txt” aquellos productos cuyo stock actual esté por debajo del stock mínimo permitido');
  readln(menu);
  case menu of
    1: begin
         assign(maestro, 'MAESTRO');
         assign(detalle, 'DETALLE');
         reset(maestro);
         reset(detalle);
         leerDetalle (detalle,ven);
         while (ven.cod<>valorAlto) do begin
          while prod.cod <> ven.cod do 
            leerMaestro(maestro, prod);
          prod.stockAct := prod.stockAct - ven.cant;
          seek(maestro, filePos(maestro) - 1);
          write(maestro, prod);
          leerDetalle(detalle, ven);
        end;
        close (maestro);
        close (detalle);
       end;
    2: begin
          assign (texto, 'stock_minimo.txt');
          rewrite (texto);
          assign (maestro, 'MAESTRO');
          reset (maestro);
          while (not eof(maestro)) do begin
            leerMaestro (maestro,prod);
            if (prod.StockMin>prod.stockAct) then 
              writeln (texto, prod.nom, ' cod:', prod.cod, ' stockACT:', prod.stockAct, ' stock minimo:', prod.StockMin);
          end;
          close (maestro);
          close (texto);
       end;
    else 
      writeln('Numero no valido');
  end;
end.
