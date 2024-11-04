program p3e8;

type
    
    doc=record
    dni:integer;
    nom,ape:string;
    end;
    
    proyect=record
    cod,alu:integer;
    loc,nom,tit:string;
    doc:doc;
    esc:string;
    end;


procedure leer (p:proyect);    
begin
readln (p.cod);
readln (p.tit);
readln (p.alu);
readln (p.esc);
readln (p.loc);
readln (p.doc.dni);
readln (p.doc.nom);
readln (p.doc.ape);
end;


procedure actualizarmax (esc:string; var max1,max2:string ; cant:integer; var cmax1,cmax2: integer);
begin 
if cant>cmax1 then 
begin
cmax2:= cmax1;
cmax1:= cant;
max2:= max1;
max1:= esc;
end
else 
begin
if (cant>cmax2) then 
    begin
    cmax2:=cant;
    max2:=esc;
    end;
end;

end;

function pares (cod:integer): integer;
var
par:integer;
num:integer;
begin
par:=0;
while (cod <> 0) do begin
    num:=cod mod 10;
    if (num mod 2 = 0) then
        par:=par+1;
    cod := cod div 10;
end;
pares:=par;
end;

function impares (cod:integer): integer;
var
impar:integer;
num:integer;
begin
impar:=0;
while (cod <> 0) do begin
    num:=cod mod 10;
    if (num mod 2 = 1) then
        impar:=impar+1;
    cod := cod div 10;
end;
impares:=impar;
end;

var

p:proyect;
locactual,escactual:string;
aluesc,totalu,canttot,cantloc:integer;
max1,max2:string;
cmax1,cmax2:integer;
begin
cmax1:=-1;
cmax2:=-2;
canttot:=0;
leer (p);
while (p.cod<>-1) do begin
    locactual:=p.loc;
 
    while (locactual=p.loc) do begin
        cantloc:=0;
        escactual:=p.nom;
        canttot:=canttot+1;
        totalu:=0;
        cantloc:=cantloc+1;
        aluesc:=0;
        while (escactual=p.nom) do begin
            aluesc:=aluesc+p.alu;
            totalu:=totalu+p.alu;
            leer (p); 
            if (locactual='Daireaux') then begin
                if (pares (p.cod) = impares (p.cod)) then 
                writeln (p.tit, ' es un proyecto de la localidad de Daireaux cuyo codigo tiene igual cantidad de digitos pares que impares');
        end;
        
    actualizarmax (escactual,max1,max2,aluesc,cmax1,cmax2);
    end;
 writeln ('la cantidad de escuelas de la localidad ', locactual, ' es ', cantloc);
end;

writeln ('la cantidad total de escuelas es ', canttot);

writeln ('la dos escuelas con mas cantidad de participantes es ', max1, ' y ', max2);

end;

end.