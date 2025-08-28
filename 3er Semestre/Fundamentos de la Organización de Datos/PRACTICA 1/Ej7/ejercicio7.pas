program ejercicio7;
uses
  SysUtils;

type
  novela = record
    cod: integer;
    nom, gen: string[30];
    pre: real;
  end;

  archivobinario = file of novela;

var 
  novelastxt: Text;
  novelasbin: archivobinario;
  nombrearchivo: string[20];

procedure creararchivo ();
var
  n: novela;
begin
  assign(novelastxt, 'novelas.txt');
  assign(novelasbin, nombrearchivo);
  reset(novelastxt);
  rewrite(novelasbin);
  while (not eof(novelastxt)) do begin 
    with n do begin
      readln(novelastxt, cod, pre, gen);
      readln(novelastxt, nom);
    end;
    write(novelasbin, n);
  end;
  close(novelastxt);
  close(novelasbin);
end;

procedure agregarnovela (n: novela);
begin
  assign(novelasbin, nombrearchivo);
  reset(novelasbin);
  seek(novelasbin, fileSize(novelasbin));
  write(novelasbin, n);
  close(novelasbin);
end;

procedure imprimireg (n:novela);
begin
  with n do begin 
    writeln ('cod: ', cod);
    writeln ('nombre: ', nom);
    writeln ('genero: ', gen);
    writeln ('precio: ', pre:0:2);
  end;
end;

procedure imprimir ();
var n:novela;
begin
  assign (novelasbin, nombrearchivo);
  reset (novelasbin);
  while (not eof(novelasbin)) do 
  begin 
    read (novelasbin, n);
    imprimireg (n);
  end;
  close (novelasbin);
end;

var 
  menu: integer;
  n: novela;
  aux: string;
  auxi: integer;
begin
  repeat 
    writeln('Que desea hacer?');
    writeln('[1] Crear un archivo binario a partir de la informacion almacenada en "novelas.txt"');
    writeln('[2] Abrir el archivo binario y agregar una novela');
    writeln('[3] Abrir el archivo binario y modificar una novela');
    writeln('[4] Imprimir el archivo binario');
    writeln('[5] Terminar el programa');
  
    readln(menu);
    case menu of
      1:
      begin
        writeln('Que nombre quiere darle al archivo?');
        readln(nombrearchivo); 
        creararchivo();
      end;
      2:
      begin
        with n do begin 
          writeln('Ingrese el nombre de la novela nueva');
          readln(nom);
          writeln('Ingrese el codigo de la novela nueva');
          readln(cod);
          writeln('Ingrese el genero de la novela nueva');
          readln(gen);
          writeln('Ingrese el precio de la novela nueva');
          readln(pre);
        end;
        agregarnovela(n);
      end;
      3: 
      begin
        writeln('Ingrese el codigo de la novela que quiere modificar');
        readln(auxi);
        assign(novelasbin, nombrearchivo);
        reset(novelasbin);
        repeat
          read(novelasbin, n);
        until (eof(novelasbin)) or (auxi = n.cod);
        if (auxi = n.cod) then begin
          writeln('Ingrese los nuevos datos de la novela, si quiere dejar algun dato igual, toque enter.');
          writeln('Nombre:');
          readln(aux);
          if (aux <> '') then n.nom := aux;
          writeln('Genero:');
          readln(aux);
          if (aux <> '') then n.gen := aux;
          writeln('Precio:');
          readln(aux);
          if (aux <> '') then n.pre := StrToFloat(aux);
          seek(novelasbin, filePos(novelasbin) - 1);
          write(novelasbin, n)
        end
        else 
          writeln('Ese codio de novela no existe');
        close(novelasbin);
      end;
      4:
        imprimir ();
      5: 
      writeln('Cerrando programa');
    else
      writeln('Porfavor ingrese una opcion valida.');
    end;
  until (menu = 5);   
end.
