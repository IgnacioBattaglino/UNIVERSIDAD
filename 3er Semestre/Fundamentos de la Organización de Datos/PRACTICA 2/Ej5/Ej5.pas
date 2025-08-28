program ej5;
const 
    valorAlto=9999;
    dimF=4;

type
    subrango = 1..dimF;
    producto=record
        cod,stockDis,stockMin,pre:integer;
        nombre,des:string;
    end;
    venta=record
        cod,cant:integer;
    end;

    maestro=file of producto;
    detalle=file of venta;

    archivos= array [subrango] of detalle; 
    registros= array [subrango] of venta;

procedure leer(var det: detalle; var dato: venta);
  begin
    if(not eof(det)) then
        read(det, dato)
    else
        dato.cod:= valoralto;  
  end;    

procedure minimo (var ar:archivos; var reg: registros ;var min: venta);
  var 
  i,pos:subrango;

  begin
    min.cod:=valorAlto;
    for i:=1 to dimF do 
        if (reg[i].cod<min.cod) then begin
            min:= reg[i]; 
            pos:=i;
        end;
    if (min.cod<>valorAlto) then 
        leer (ar[pos],reg[pos]);
  end;

procedure imprimirMaestro(var mae: maestro);
var
    p: producto;
begin
    reset(mae);
    while(not eof(mae)) do
        begin
            read(mae, p);
            writeln('Codigo=', p.cod, ' StockDisp=', p.stockDis, ' StockMin=', p.stockMin, ' Precio=', p.pre, ' Nombre=', p.nombre, ' Desc=', p.des);
        end;
    close(mae);
end;

var 
mae:maestro;
min:venta;
i:subrango;
vecArchivos:archivos;
vecVentas: registros;
act:venta;
nombreArchivo,c:string;
infoMae:producto;
begin
    for i:= 1 to dimF do begin 
        Str(i,c);
        nombreArchivo:= 'DETALLE' + c;
        assign (vecArchivos[i], nombreArchivo);
        reset (vecArchivos[i]);
        leer (vecArchivos[i],vecVentas[i]);
    end;
    assign (mae, 'MAESTRO');
    reset (mae);
    minimo (vecArchivos, vecVentas,min);
    while (min.cod<>valorAlto) do begin 
        act.cod:=min.cod;
        while (min.cod=act.cod) do begin 
            act.cant:= act.cant + min.cant;
            minimo (vecArchivos, vecVentas,min);
        end;
        read (mae,infoMae);
        while (infoMae.cod<>act.cod) do
            read (mae,infoMae);
        infoMae.stockDis:=infoMae.stockDis-act.cant;
        seek (mae, filepos(mae)-1);
        write (mae,infoMae);
        act.cant:=0;
    end;    
    for i:= 1 to dimF do begin 
        close (vecArchivos[i]);
    end;
    close (mae);
    imprimirMaestro (mae);
end.
