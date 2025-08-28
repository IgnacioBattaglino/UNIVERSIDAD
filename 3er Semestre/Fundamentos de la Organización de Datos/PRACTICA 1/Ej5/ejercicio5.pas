program ejercicio5;
type
  celular=record
    cod:integer;
    nom:string;
    desc:string;
    marca:string;
    pre:real;
    stockdis,stockmin:integer; 
  end;

  archivoreg= file of celular;

var 
  regcelus: archivoreg;
  celulares: Text;

procedure creararchivo ();
var 
nom:string;
reg:celular;
begin
  writeln ('Ingrese el nombre que le quiere dar al archivo');
  readln (nom);
  assign (regcelus,nom);
  rewrite (regcelus);
  assign (celulares,'celulares.txt');
  reset (celulares);
  while (not eof(celulares)) do begin
    writeln ('------------');
    with reg do begin 
      writeln ('------------');
      readln (celulares,cod);
      readln (celulares,nom);
      readln (celulares,desc);
      readln (celulares,marca);
      readln (celulares,pre);
      readln (celulares,stockdis);
      readln (celulares,stockmin);
      writeln ('------------');
      write (regcelus,reg);
    end;
  end;
  writeln ('------------');
  close (regcelus);
  close (celulares);
end; 

procedure imprimireg (r:celular);
begin
  with r do begin 
    writeln ('cod: ', cod);
    writeln ('nombre: ', nom);
    writeln ('descripcion: ', desc);
    writeln ('marca: ', marca);
    writeln ('precio: ', pre:0:2, 'USD');
    writeln ('stock disponible: ', stockdis);
    writeln ('stock minimo: ', stockmin);
  end;
end;

procedure listarstockmenor ();
var 
reg:celular;
begin 
  assign (regcelus, 'registro');
  reset (regcelus);
  while (not eof(regcelus)) do begin 
    read (regcelus, reg);
    if (reg.stockdis<reg.stockmin) then  
      imprimireg (reg);
  end;
  close (regcelus);
end;

procedure listardescripcion();
var 
  reg: celular;
  desc: string;
begin
  writeln ('Ingrese el dato de descripcion que quiere buscar:');
  readln (desc);
  assign (regcelus, 'registro');
  reset (regcelus);
  while (not eof(regcelus)) do 
  begin 
    read (regcelus, reg);
    if (Pos(desc, reg.desc) <> 0) then  
      imprimireg (reg);
  end;
  close (regcelus);
end;

procedure binarioatexto ();
var 
reg:celular;
begin
  assign (regcelus,'registro');
  reset (regcelus);
  assign (celulares,'celulares2.txt');
  rewrite (celulares);
  while (not eof(regcelus)) do begin
    read (regcelus,reg);
    with reg do begin 
      writeln (celulares,cod);
      writeln (celulares,nom);
      writeln (celulares,desc);
      writeln (celulares,marca);
      writeln (celulares,pre);
      writeln (celulares,stockdis);
      writeln (celulares,stockmin);
    end;
  end;
  close (regcelus);
  close (celulares);
end;

var 
menu:integer;

begin
  menu:=-1;
  while (menu<>5) do begin 
    writeln ('Bienvenido al programa de la tienda, ingrese:');
    writeln ('[1] para crear un archivo de registro de celulares cargado con los datos en "celulares.txt."');
    writeln ('[2] para listar en pantalla los datos de los celulares con un stock menor al stock minimo. ');
    writeln ('[3] para listar en pantalla los celulares cuya descripcion contenga algo especifico.');
    writeln ('[4] para exportar el archivo creado a un archivo de texto denominado "celulares.txt".');
    writeln ('[5] para salir del programa.');
    readln (menu);
    case menu of
      1:
        creararchivo();
  
      2:
        listarstockmenor();

      3:
        listardescripcion();
      4:
        binarioatexto();
      5:
        halt;
      else
        writeln ('Porfavor ingrese una opcion valida.');
    end;
  end;  
end.