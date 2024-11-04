program adicional3;



type
range= 1..10;

producto=record
    cod:integer;
    rubro:range;
    stock:integer;
    precio:real;
end;

productol=record
    cod,stock:integer;
    precio:real;
end;

lista=^nodo;
nodo=record
    sig:lista;
    dato:productol;
end;

vector= array [1..10] of lista;

procedure iniciarvector (var v:vector);
var i:integer;
begin
    for i:= 1 to 10 do begin
        v[i]:=nil;
    end;
end;

procedure cargarvector(var v: vector; p: producto);
var
  actual, anterior, nuevo: lista;
begin
  new(nuevo);
  nuevo^.sig := nil;
  nuevo^.dato.cod := p.cod;
  nuevo^.dato.stock := p.stock;
  nuevo^.dato.precio := p.precio;

  if (v[p.rubro] = nil) then
    v[p.rubro] := nuevo
  else
  begin
    actual := v[p.rubro];
    anterior := nil;

    while (actual <> nil) and (actual^.dato.cod < nuevo^.dato.cod) do
    begin
      anterior := actual;
      actual := actual^.sig;
    end;

    if (actual = v[p.rubro]) then
    begin
      nuevo^.sig := v[p.rubro];
      v[p.rubro] := nuevo;
    end
    else
    begin
      anterior^.sig := nuevo;
      nuevo^.sig := actual;
    end;
  end;
end;

    
procedure enviardatos (var v:vector);
var p:producto;
begin
    p.cod:=6;
    p.rubro:=5;
    p.stock:=25;
    p.precio:=100;
    cargarvector (v,p);   
    p.cod:=23;
    p.rubro:=2;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=10;
    p.rubro:=1;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=11;
    p.rubro:=4;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=1;
    p.rubro:=1;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=2;
    p.rubro:=2;
    p.stock:=60;
    p.precio:=150;
    cargarvector (v,p);    
    p.cod:=3;
    p.rubro:=3;
    p.stock:=10;
    p.precio:=500;
    cargarvector (v,p);
    p.cod:=4;
    p.rubro:=1;
    p.stock:=20;
    p.precio:=240.5;
    cargarvector (v,p);
    p.cod:=5;
    p.rubro:=2;
    p.stock:=500;
    p.precio:=20;
    cargarvector (v,p);
    p.cod:=30;
    p.rubro:=5;
    p.stock:=25;
    p.precio:=100;
    cargarvector (v,p);   
    p.cod:=50;
    p.rubro:=2;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=27;
    p.rubro:=1;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=100;
    p.rubro:=4;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=80;
    p.rubro:=1;
    p.stock:=50;
    p.precio:=100;
    cargarvector (v,p);
    p.cod:=67;
    p.rubro:=2;
    p.stock:=60;
    p.precio:=150;
    cargarvector (v,p);    
    p.cod:=43;
    p.rubro:=3;
    p.stock:=10;
    p.precio:=500;
    cargarvector (v,p);
    p.cod:=56;
    p.rubro:=1;
    p.stock:=20;
    p.precio:=240.5;
    cargarvector (v,p);
    p.cod:=105;
    p.rubro:=2;
    p.stock:=500;
    p.precio:=20;
    cargarvector (v,p);
end;

procedure imprimirlista (l:lista);
begin
    if (l<>nil) then begin
        writeln ('cod ', l^.dato.cod);
        writeln ('stock ', l^.dato.stock);
        imprimirlista (l^.sig);
    end;
end;

procedure imprimirvec (v:vector);
var i:integer;
begin
    for i:= 1 to 10 do begin
        writeln ('lista rubro ', i);
        imprimirlista (v[i])
    end;
end;
    
function buscarcodenrubro (v:vector; cod:integer; rubro: range): boolean;
var aux:boolean;
begin
    aux:=false;
    while (aux=false) and (v[rubro]<>nil) do begin
        if (v[rubro]^.dato.cod=cod) then aux:=true;
        v[rubro]:=v[rubro]^.sig; 
    end;
    buscarcodenrubro:=aux;
end;
    
procedure maxcode (v:vector);
var i:integer;
maxc,maxs:integer;
begin
    for i:= 1 to 10 do begin
        maxc:=-1;
        maxs:=-1;
        while (v[i]<>nil) do begin
            if (v[i]^.dato.stock>maxs) then begin
                maxc:=v[i]^.dato.cod; 
                maxs:=v[i]^.dato.stock;
            end;
            v[i]:=v[i]^.sig;
        end;
    if (maxc<>-1) then writeln ('el producto con mas stock del rubro ',i, ' es el de codigo ', maxc)
    else
        writeln ('no hay productos registrados en el rubro ', i);
    end;
end;
    
procedure cantentredoscodes (v:vector; cod1,cod2:integer);
var cant,i:integer;
begin 
    for i:= 1 to 10 do begin
        cant:=0;
        while (v[i]<>nil) and (v[i]^.dato.cod<cod1) do begin
            v[i]:=v[i]^.sig;
        end;
        while (v[i]<>nil) and (v[i]^.dato.cod<cod2) do begin
            cant:=cant+1;
            v[i]:=v[i]^.sig;
        end;
        writeln ('la cantidad de codigos entre los valores dados del rubro ',i,' es ', cant);    
    end;
end;

var
vec:vector;
begin
    iniciarvector (vec);
    enviardatos (vec);
    writeln ('datos cargados');
    imprimirvec (vec);
    writeln (buscarcodenrubro (vec,1,1));
    maxcode (vec);
    cantentredoscodes (vec,1,1000);
end.
