program p1;
const
type
var 
	car1,car2,car2: char;
	
begin
	write 'inserte un caracter y presione enter, luego ingrese el segundo, vuelva a presionar enter y finalmente el tercero.';
	read (car1);
	read (car2);
	read (car3);
	
	if car1<>a,e,i,o,u or car2 <>a,e,i,o,u or car3<>a,e,i,o,u do
		write 'al menos uno de los caracteres no era vocal';
	else 
		write 'Los tres son vocales';
	
	end.