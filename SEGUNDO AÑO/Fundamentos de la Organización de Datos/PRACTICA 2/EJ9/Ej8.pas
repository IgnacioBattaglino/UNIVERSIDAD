program ej9;
const 
    valorAlto=9999;
type

  infoMaestro = record
    codprov, codloc, num, cant: integer;
  end;

  maestro = file of infoMaestro;


procedure leer (var archivo: maestro; var dato:infoMaestro);
begin 
    if (not eof(archivo)) then
        read (archivo,dato)
    else 
        dato.codprov:=valorAlto;
end;

procedure obtener_reporte(var archivo: maestro);
var 
    dato:infoMaestro;
    provact,locact,totalprov,totalloc,total:integer;
begin
    total:=0;
    leer (archivo,dato);
    while (dato.codprov<>valorAlto) do begin 
        provact:=dato.codprov;
        totalprov:=0;
        writeln('Codigo de provincia: ', dato.codprov);
        while (dato.codprov=provact) do begin 
            locact:= dato.codloc;
            totalloc:=0;
            writeln('Codigo de localidad:           total de votos:');
            while (dato.codprov=provact) and (locact=dato.codloc) do begin
                totalloc:=totalloc+ dato.cant;
                leer (archivo,dato);
            end;
            writeln ('                     ', locact, '                          ', totalloc);
            totalprov:=totalprov+totalloc;
        end;
        writeln('Total de votos Provincia: ', totalprov);
        total:=total+totalprov;
    end;
    writeln ('.............................................................');
    writeln ('Total general de votos: ', total)
end;

var
mae:maestro;

begin
    assign (mae,'MAESTRO');
    reset (mae);
    obtener_reporte (mae);
    close (mae);
end.