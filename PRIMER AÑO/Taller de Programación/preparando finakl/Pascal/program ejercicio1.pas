program ejercicio1;

type

ofi= record
  cod:integer;
  dni:longint;
  exp:real;
end;

oficinas = array [1..300] of ofi; 

procedure leer (var o:ofi);
begin
  writeln ('Ingrese el dni del propietario');
  readln (o.dni);
  writeln ('Ingrese el codigo de identificacion de la oficina');
  readln (o.cod);
  if (o.cod<>-1) then begin 
    writeln ('Ingrese el valor de la expensa');
    readln (o.exp); 

  end;
end;

procedure cargar(var v:oficinas; var diml:integer);
var
    o:ofi;
begin 
    diml:=0;
    o.cod:=1;
    while (o.cod<>-1) and (diml<=300) do 
    begin 
        leer (o);
        if (o.cod<>-1) then begin 
            diml:=diml+1;
            v[diml]:=o;
        end;
    end;
end;

procedure ordenar (var v:oficinas; diml: integer);
    var pos,j,i:integer;
    o:ofi;
    begin 
        for i:=1 to diml-1 do begin 
            pos:=i;
            for j:= i+1 to diml do 
                if v[j].cod < v[pos].cod then pos:= j;
            o:= v[pos];
            v[pos]:= v[i];
            v[i]:= o;
        end;
    end;

function dicotomica (v:oficinas; cod,inf,sup:integer):integer;
    var pos:integer;
    begin  
        if ((cod > v[sup].cod) or (cod < v[inf].cod)) then dicotomica := 0
            else 
            begin
            pos:= (inf+sup) div 2;
            writeln (pos);
            if (v[pos].cod=cod) then dicotomica:= pos
            else 
                if (v[pos].cod>cod) then dicotomica:= dicotomica (v,cod,inf,pos-1) 
            else 
                dicotomica:= dicotomica (v,cod,pos+1,sup)
            end;
    end;
    
    
function total (v:oficinas; diml,i:integer):real;
begin
    if (i<=diml) then begin
        total:= total (v, diml, i+1) + v[i].exp;
    end
    else 
        total:= 0; 
end;

procedure cargar2 (var v:oficinas; var diml:integer);
var 
    o:ofi;
begin
    diml:=5;
    o.dni:= 46269132;
    o.cod:= 5;
    o.exp:= 1000;
    v[1]:= o;
    o.dni:= 22851780;
    o.cod:= 32;
    o.exp:= 300;
    v[2]:= o;
    o.dni:= 12981944;
    o.cod:= 4;
    o.exp:= 100;
    v[3]:= o;
    o.dni:= 74289201;
    o.cod:= 1;
    o.exp:= 150;
    v[4]:= o;
    o.dni:= 1285281;
    o.cod:= 12;
    o.exp:= 150;
    v[5]:= o;
    
end;

procedure imprimir (v:oficinas; diml:integer);
var 
i:integer;
begin
    writeln ('hola');
    for i:= 1 to diml do begin
        writeln (v[i].dni, ' ', v[i].cod, ' ', v[i].exp:0:2);
    end;
end;

var
vec:oficinas;
diml:integer;
aux:integer;
begin

// cargar (vec,diml);
cargar2 (vec,diml);
imprimir (vec,diml);
ordenar (vec,diml);
imprimir (vec,diml);

aux:= dicotomica (vec,4,1,diml);


if (aux = 0) then writeln ('No se encontro la oficina')
else writeln ('el dni del propietario de la oficina 5 es ', vec [aux].dni);

writeln (' el total de las expensas es ', total (vec, diml,1):0:2)

end.

(*
ERRORES
Orden de los parametros funciones.
Dicotomica: poner el else indentado.

*)