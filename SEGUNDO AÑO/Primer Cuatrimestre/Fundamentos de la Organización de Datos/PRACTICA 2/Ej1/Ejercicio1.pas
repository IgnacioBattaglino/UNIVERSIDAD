program pr2ej1;
const 
  valoralto = 9999;
type

empleado = record
  cod:integer;
  nom:string;
  mon:real;
end;

archivoCompacto= file of empleado; 

var
  nombrearchivo:string;
  compacto:archivoCompacto;
  carga: text;

procedure leer(var arc: text; var dato: empleado);
begin
    if(not(eof(arc))) then
        readln(arc, dato.cod, dato.mon, dato.nom)
    else
        dato.cod := valoralto;
end;

procedure imprimir (var arc: archivoCompacto);
var
    emp: empleado;
begin
    reset (arc);
    while (not eof(arc)) do begin
        read (arc, emp);
        writeln ('Codigo: ', emp.cod);
        writeln ('Nombre: ', emp.nom);
        writeln ('Monto: ', emp.mon:0:2);
        writeln ('---------');
    end;
    close (arc);
end;

var

emp:empleado;
act:empleado;


begin
  writeln ('Ingrese el nombre del archivo del que quiere leer');
  readln (nombrearchivo);
  assign (carga, nombrearchivo);
  reset (carga);
  writeln ('Ingrese el nombre que quiere darle al nuevo archivo compacto');
  readln (nombrearchivo);
  assign (compacto, nombrearchivo);
  rewrite (compacto);
  
  leer (carga, emp);
  while (emp.cod<>valoralto) do begin 
    act:= emp;
    act.mon:=0;
    while (emp.cod<>valoralto) and(emp.cod=act.cod) do begin 
      act.mon:= act.mon + emp.mon;
      leer (carga,emp);
    end;   
    write (compacto, act);
  end;
  imprimir (compacto);
  close (compacto)
  close (carga);
end.