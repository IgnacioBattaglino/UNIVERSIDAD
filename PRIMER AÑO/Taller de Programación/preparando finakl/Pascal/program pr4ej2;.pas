program pr4ej2;
type
prestamo=record
    cant,isbn,num:integer;
    dia:string;
end;

prestamo2=record
    cant,num:integer;
    dia:string;
end;

datolista=record
    isbn,cant:integer;
end;

lista2=^nodo3;
nodo3=record
    dato:datolista;
    sig:lista2;
end;

arbol1=^nodo1;
nodo1=record
    dato:prestamo;
    hd:arbol1;
    hi:arbol1;
end;

lista=^nodo;
nodo=record
    sig:lista;
    dato:prestamo2;
end;

datoarbol=record
    lista:lista;
    isbn:integer;
end;

arbol2=^nodo2;
nodo2=record
    dato:datoarbol;
    hd:arbol2;
    hi:arbol2;
end;

procedure agregaralarbol (var a:arbol1; p:prestamo);
begin
    if (a=nil) then begin
        new (a);
        a^.dato:=p;
        a^.hd:=nil;
        a^.hi:=nil
    end
    else     
        if (a^.dato.isbn>p.isbn) then agregaralarbol (a^.hi,p)
    else 
        agregaralarbol (a^.hd,p);
end;

procedure forzardatos (var a:arbol1);
var p:prestamo;
begin
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 1;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 2;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 3;
    p.num:= 2;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 4;
    p.num:= 2;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 5;
    p.num:= 2;
    p.dia:= '03/07';
    agregaralarbol(a,p);
    p.cant:= 20;
    p.isbn:= 6;
    p.num:= 2;
    p.dia:= '23/06';
    agregaralarbol(a,p);
    p.cant:= 7;
    p.isbn:= 7;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 1;
    p.isbn:= 8;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol(a,p);
    p.cant:= 18;
    p.isbn:= 9;
    p.num:= 9;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 10;
    p.num:= 10;
    p.dia:= '29/03';
    agregaralarbol(a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 1;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 2;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 3;
    p.num:= 2;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 4;
    p.num:= 2;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 5;
    p.num:= 2;
    p.dia:= '03/07';
    agregaralarbol(a,p);
    p.cant:= 20;
    p.isbn:= 6;
    p.num:= 2;
    p.dia:= '23/06';
    agregaralarbol(a,p);
    p.cant:= 7;
    p.isbn:= 7;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 1;
    p.isbn:= 8;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol(a,p);
    p.cant:= 18;
    p.isbn:= 9;
    p.num:= 9;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 10;
    p.num:= 10;
    p.dia:= '29/03';
    agregaralarbol(a,p);
    p.cant:= 15;
    p.isbn:= 11;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 22;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 12;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 13;
    p.num:= 3;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 14;
    p.num:= 4;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 15;
    p.num:= 5;
    p.dia:= '03/07';
    agregaralarbol (a,p);
    p.cant:= 20;
    p.isbn:= 16;
    p.num:= 6;
    p.dia:= '23/06';
    agregaralarbol (a,p);
    p.cant:= 7;
    p.isbn:= 17;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 1;
    p.isbn:= 18;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 19;
    p.num:= 11;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 20;
    p.num:= 11;
    p.dia:= '29/03';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 7;
    p.isbn:= 25;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 11;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 22;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 12;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 13;
    p.num:= 3;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 14;
    p.num:= 4;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 15;
    p.num:= 5;
    p.dia:= '03/07';
    agregaralarbol (a,p);
    p.cant:= 20;
    p.isbn:= 16;
    p.num:= 6;
    p.dia:= '23/06';
    agregaralarbol (a,p);
    p.cant:= 7;
    p.isbn:= 17;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 1;
    p.isbn:= 18;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 19;
    p.num:= 11;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 1;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 2;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 3;
    p.num:= 2;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 1;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 4;
    p.num:= 2;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 5;
    p.num:= 2;
    p.dia:= '03/07';
    agregaralarbol(a,p);
    p.cant:= 20;
    p.isbn:= 6;
    p.num:= 2;
    p.dia:= '23/06';
    agregaralarbol(a,p);
    p.cant:= 7;
    p.isbn:= 7;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 1;
    p.isbn:= 8;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol(a,p);
    p.cant:= 18;
    p.isbn:= 9;
    p.num:= 9;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 10;
    p.num:= 10;
    p.dia:= '29/03';
    agregaralarbol(a,p);
    p.cant:= 15;
    p.isbn:= 11;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 22;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 12;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 13;
    p.num:= 3;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 14;
    p.num:= 4;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 15;
    p.num:= 5;
    p.dia:= '03/07';
    agregaralarbol (a,p);
    p.cant:= 20;
    p.isbn:= 16;
    p.num:= 6;
    p.dia:= '23/06';
    agregaralarbol (a,p);
    p.cant:= 7;
    p.isbn:= 17;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 1;
    p.isbn:= 18;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 19;
    p.num:= 11;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 20;
    p.num:= 11;
    p.dia:= '29/03';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 7;
    p.isbn:= 25;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 20;
    p.num:= 11;
    p.dia:= '29/03';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 7;
    p.isbn:= 25;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 1;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 2;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 3;
    p.num:= 2;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 4;
    p.num:= 2;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 5;
    p.num:= 2;
    p.dia:= '03/07';
    agregaralarbol(a,p);
    p.cant:= 20;
    p.isbn:= 6;
    p.num:= 2;
    p.dia:= '23/06';
    agregaralarbol(a,p);
    p.cant:= 7;
    p.isbn:= 7;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 1;
    p.isbn:= 8;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol(a,p);
    p.cant:= 18;
    p.isbn:= 9;
    p.num:= 9;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 10;
    p.num:= 10;
    p.dia:= '29/03';
    agregaralarbol(a,p);
    p.cant:= 15;
    p.isbn:= 11;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 22;
    p.dia:= '10/12';
    agregaralarbol (a,p);
    p.cant:= 50;
    p.isbn:= 12;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol (a,p);
    p.cant:= 21;
    p.isbn:= 13;
    p.num:= 3;
    p.dia:= '09/11';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 14;
    p.num:= 4;
    p.dia:= '01/02';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 15;
    p.num:= 5;
    p.dia:= '03/07';
    agregaralarbol (a,p);
    p.cant:= 20;
    p.isbn:= 16;
    p.num:= 6;
    p.dia:= '23/06';
    agregaralarbol (a,p);
    p.cant:= 7;
    p.isbn:= 17;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 1;
    p.isbn:= 18;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol (a,p);
    p.cant:= 18;
    p.isbn:= 19;
    p.num:= 11;
    p.dia:= '19/01';
    agregaralarbol (a,p);
    p.cant:= 10;
    p.isbn:= 20;
    p.num:= 11;
    p.dia:= '29/03';
    agregaralarbol (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol (a,p); 
    p.cant:= 7;
    p.isbn:= 25;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol (a,p);
end;

procedure agregaradelante (var l:lista; p:prestamo);
var
nuevo:lista;
begin
    new (nuevo);
    nuevo^.dato.cant:=p.cant;
    nuevo^.dato.num:=p.num;
    nuevo^.dato.dia:=p.dia;
    nuevo^.sig:=nil;
    if (l=nil) then 
        l:=nuevo
    else
        begin
            nuevo^.sig:=l;
            l:=nuevo;
        end;
end;

procedure agregaralarbol2 (var a:arbol2; p:prestamo);
begin
    if (a=nil) then begin
        new (a);
        a^.dato.isbn:=p.isbn;
        a^.hd:=nil;
        a^.hi:=nil;
        a^.dato.lista:=nil;
        agregaradelante (a^.dato.lista,p)
    end
    else     
        if (a^.dato.isbn=p.isbn) then agregaradelante (a^.dato.lista,p)
    else 
        if (a^.dato.isbn>p.isbn) then agregaralarbol2 (a^.hi,p)
    else 
        agregaralarbol2 (a^.hd,p);
end;

procedure forzardatos2 (var a:arbol2);
var p:prestamo;
begin
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 1;
    p.dia:= '10/12';
    agregaralarbol2 (a,p);
    p.cant:= 50;
    p.isbn:= 2;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol2 (a,p);
    p.cant:= 21;
    p.isbn:= 3;
    p.num:= 3;
    p.dia:= '09/11';
    agregaralarbol2 (a,p);
    p.cant:= 18;
    p.isbn:= 4;
    p.num:= 4;
    p.dia:= '01/02';
    agregaralarbol2 (a,p);
    p.cant:= 15;
    p.isbn:= 5;
    p.num:= 5;
    p.dia:= '03/07';
    agregaralarbol2 (a,p);
    p.cant:= 20;
    p.isbn:= 6;
    p.num:= 6;
    p.dia:= '23/06';
    agregaralarbol2 (a,p);
    p.cant:= 7;
    p.isbn:= 7;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol2 (a,p);
    p.cant:= 1;
    p.isbn:= 8;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol2 (a,p);
    p.cant:= 18;
    p.isbn:= 9;
    p.num:= 9;
    p.dia:= '19/01';
    agregaralarbol2 (a,p);
    p.cant:= 10;
    p.isbn:= 10;
    p.num:= 10;
    p.dia:= '29/03';
    agregaralarbol2 (a,p);
    p.cant:= 15;
    p.isbn:= 11;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol2 (a,p);
    p.cant:= 10;
    p.isbn:= 1;
    p.num:= 22;
    p.dia:= '10/12';
    agregaralarbol2 (a,p);
    p.cant:= 50;
    p.isbn:= 12;
    p.num:= 2;
    p.dia:= '1/10';
    agregaralarbol2 (a,p);
    p.cant:= 21;
    p.isbn:= 13;
    p.num:= 3;
    p.dia:= '09/11';
    agregaralarbol2 (a,p);
    p.cant:= 18;
    p.isbn:= 14;
    p.num:= 4;
    p.dia:= '01/02';
    agregaralarbol2 (a,p);
    p.cant:= 15;
    p.isbn:= 15;
    p.num:= 5;
    p.dia:= '03/07';
    agregaralarbol2 (a,p);
    p.cant:= 20;
    p.isbn:= 16;
    p.num:= 6;
    p.dia:= '23/06';
    agregaralarbol2 (a,p);
    p.cant:= 7;
    p.isbn:= 17;
    p.num:= 7;
    p.dia:= '15/04';
    agregaralarbol2 (a,p);
    p.cant:= 1;
    p.isbn:= 18;
    p.num:= 8;
    p.dia:= '17/02';
    p.cant:= 1;
    p.isbn:= 18;
    p.num:= 8;
    p.dia:= '17/02';
    agregaralarbol2 (a,p);
    p.cant:= 18;
    p.isbn:= 19;
    p.num:= 9;
    p.dia:= '19/01';
    agregaralarbol2 (a,p);
    p.cant:= 10;
    p.isbn:= 20;
    p.num:= 10;
    p.dia:= '29/03';
    agregaralarbol2 (a,p);
    p.cant:= 15;
    p.isbn:= 21;
    p.num:= 11;
    p.dia:= '15/05';
    agregaralarbol2 (a,p); 
end;

function maxisbn (a:arbol1):integer;
begin
    if (a<>nil) then begin 
        if (a^.hd=nil) then 
            maxisbn:=a^.dato.isbn
        else 
            maxisbn:= maxisbn (a^.hd);
        end
    else
        maxisbn:=0;
end;

function minisbn (a:arbol2):integer;
begin
    if (a<>nil) then begin 
        if (a^.hi=nil) then 
            minisbn:=a^.dato.isbn
        else 
            minisbn:= minisbn (a^.hi);
        end
    else
        minisbn:=0;
end;

procedure imprimirarbol2(a: arbol2);
var
  tempLista: lista;
begin
  if (a <> nil) then
  begin
    imprimirarbol2(a^.hi);
    writeln('isbn: ', a^.dato.isbn);
    
    // Copia temporal de la lista para no modificar la original
    tempLista := a^.dato.lista;
    while (tempLista <> nil) do
    begin
      writeln('num: ', tempLista^.dato.num);
      tempLista := tempLista^.sig;
    end;

    imprimirarbol2(a^.hd);
  end;
end;



function cantprestamos (a:arbol1; num:integer):integer;
begin
    if (a<>nil) then begin
        if (a^.dato.num=num) then cantprestamos:= cantprestamos (a^.hi,num) + cantprestamos (a^.hd,num) +1
        else
            cantprestamos:=cantprestamos (a^.hi,num) + cantprestamos (a^.hd,num)
    end
    else
        cantprestamos:=0;
end;

function cantprestamosenlista (l:lista;num:integer):integer;
begin
    if (l<>nil) then begin
        if (l^.dato.num=num) then 
            cantprestamosenlista:= cantprestamosenlista (l^.sig,num) + 1
        else
            cantprestamosenlista:= cantprestamosenlista (l^.sig,num)
    end
    else
        cantprestamosenlista:=0;
end;

function cantprestamos2 (a:arbol2; num:integer):integer;
begin
    if (a<>nil) then
        cantprestamos2:= cantprestamosenlista(a^.dato.lista,num) + cantprestamos2 (a^.hd,num) + cantprestamos2 (a^.hi,num)
    else
        cantprestamos2:= 0;
end;

procedure agregaralista (isbn:integer; var l:lista2);
var 
nuevo:lista2;
begin
    new (nuevo);
    nuevo^.dato.isbn:=isbn;
    nuevo^.dato.cant:=1;
    nuevo^.sig:=nil;
    if (l=nil) then 
        l:=nuevo
    else 
        begin
            nuevo^.sig:=l;
            l:=nuevo;
        end;
end;

procedure nuevaestructura(a: arbol1; var l: lista2);
begin
  if (a <> nil) then
  begin
    nuevaestructura(a^.hd, l);
    if (l = nil) or (l^.dato.isbn <> a^.dato.isbn) then
      agregaralista(a^.dato.isbn, l)
    else
      l^.dato.cant := l^.dato.cant + 1; 
    nuevaestructura(a^.hi, l);
  end;
end;

procedure imprimirlista (l:lista2);
begin
    while (l^.sig<>nil) do begin
        writeln ('isbn: ', l^.dato.isbn);
        writeln ('cant: ', l^.dato.cant);
        l:=l^.sig;
    end;
end;

var
a1:arbol1;
a2:arbol2;
soc:integer;
list:lista2;
begin
    a1:=nil;
    a2:=nil;
    list:=nil;
    forzardatos (a1);
    forzardatos2 (a2);
    (*
    imprimirarbol2 (a2);
    writeln ('los datos han sido cargados con exito');
    writeln ('el maximo isbn del arbol1 es ', maxisbn (a1));
    writeln ('el minimo isbn del arbol2 es ', minisbn (a2));
    writeln ('ingrese un numero de socio');
    readln (soc);
    writeln ('la cantidad de prestamos hechos por el socio ingresado fue de ', cantprestamos2(a2,soc));
    *)
    nuevaestructura (a1,list);
    imprimirlista (list);
end.