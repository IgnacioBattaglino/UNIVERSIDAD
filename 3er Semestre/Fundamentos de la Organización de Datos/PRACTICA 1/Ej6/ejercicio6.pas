program ejercicio6;
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
  nombrearchivo:string;

procedure creararchivo ();
var 
reg:celular;
begin
  writeln ('Ingrese el nombre que le quiere dar al archivo');
  readln (nombrearchivo);
  assign (regcelus,nombrearchivo);
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
  assign (regcelus, nombrearchivo);
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
  assign (regcelus, nombrearchivo);
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
  assign (regcelus,nombrearchivo);
  reset (regcelus);
  assign (celulares,'celulares.txt');
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

procedure anadircelulares ();
var 
reg:celular;
begin
  assign (regcelus,nombrearchivo);
  reset (regcelus);
  Seek(regcelus, FileSize(regcelus));
  with reg do begin 
    repeat
      writeln ('Ingrese el codigo del celular (-1 para terminar)');
      readln (cod);
      if (cod<>-1) then begin 
        writeln ('Ingrese el nombre del celular');
        readln (nom);
        writeln ('Ingrese la descripcion del celular');
        readln (desc);
        writeln ('Ingrese la marca del celular');
        readln (marca);
        writeln ('Ingrese el precio del celular en dolares');
        readln (pre);
        writeln ('Ingrese el stock disponible del celular');
        readln (stockdis);
        writeln ('Ingrese el stock minimo del celular');
        readln (stockmin);
        write (regcelus,reg);
      end;
    until (cod=-1);
  end;
  close (regcelus);
end;

procedure binarioatextosinstock ();
var 
reg:celular;
begin
  assign (regcelus,nombrearchivo);
  reset (regcelus);
  assign (celulares,'SinStock.txt');
  rewrite (celulares);
  while (not eof(regcelus)) do begin
    read (regcelus,reg);
    with reg do begin 
      if (stockdis=0) then begin 
        writeln (celulares,cod);
        writeln (celulares,nom);
        writeln (celulares,desc);
        writeln (celulares,marca);
        writeln (celulares,pre);
        writeln (celulares,stockdis);
        writeln (celulares,stockmin);
      end;
    end;
  end;
  close (regcelus);
  close (celulares);
end;

procedure modificarstock ();
var 
cel:string;
reg:celular;
stock:integer;
begin
  writeln ('Ingrese el nombre del celular al que quiere modificarle el stock.');
  readln (cel);
  writeln ('Ingrese el nuevo numero de stock');
  readln (stock);
  assign (regcelus,nombrearchivo);
  reset (regcelus);
  while (not eof(regcelus)) do begin 
    read (regcelus,reg);
    if (reg.nom=cel) then begin
      reg.stockdis:=stock;
      seek (regcelus,(filepos(regcelus)-1));
      write (regcelus,reg);
      break;
    end;
  end;
end;

var 
menu:integer;

begin
  nombrearchivo:='registro';
  repeat
    writeln ('Bienvenido al programa de la tienda, ingrese:');
    writeln ('[1] para crear un archivo de registro de celulares cargado con los datos en "celulares.txt."');
    writeln ('[2] para listar en pantalla los datos de los celulares con un stock menor al stock minimo. ');
    writeln ('[3] para listar en pantalla los celulares cuya descripcion contenga algo especifico.');
    writeln ('[4] para exportar el archivo creado a un archivo de texto denominado "celulares.txt".');
    writeln ('[5] para añadir uno o mas celular al final del archivo.');
    writeln ('[6] para modificar el stock de un celular.');
    writeln ('[7] Exportar el contenido del archivo binario a un archivo de texto denominado: "SinStock.txt", con aquellos celulares que tengan stock 0..');
    writeln ('[8] para salir del programa.');
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
        anadircelulares();
      6:
        modificarstock ();
      7:
        binarioatextosinstock ();
      8:
        halt;
      else
        writeln ('Porfavor ingrese una opcion valida.');
    end;
    until (menu=8);  
end.