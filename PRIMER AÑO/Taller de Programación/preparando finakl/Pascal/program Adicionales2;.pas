program Adicionales2;

type 
auto=record
    patente:string;
    ano:integer;
    marca:string;
    modelo:string;
end;

arbol1=^nodo1;

nodo1=record
    dato:auto;
    hi:arbol1;
    hd:arbol1;
end;

arbol2=^nodo2; 

nodo2=record
    dato:datoarbol;
    hi:arbol2;
    hd:arbol2;

end;
datoarbol=record
    marca:string;
    lista:lista;
end;

lista=^nodo;
nodo=record
    datol:auto;
    sig:lista;
end;

procedure agregar1 (var a:arbol1; dato:auto);
begin
    if (a=nil) then 
    begin
        new (a);
        a^.dato:=dato; a^.hi:=nil; a^.hd:=nil;
    end    
    else 
        if (dato.patente<= a^.dato.patente) then agregar (a^.hi,dato)
        else agregar (a^.hd,dato)
end;

procedure agregar2 (var a:arbol1; dato:auto; var l:lista);
begin
    if (a=nil) then 
    begin
        new (a);
        a^.dato.marca:=dato.marca; a^.hi:=nil; a^.hd:=nil;
        agregaralista (l)
    end    
    else 
        if (dato.marca = a^.dato.marca) then 
            agregaralista (l)
        else     
            if (dato.marca < a^.dato.marca) then agregar (a^.hi,dato)
            else agregar (a^.hd,dato)
end;

procedure agregarlista (var l:lista);
begin
    
end;


begin 

end;
