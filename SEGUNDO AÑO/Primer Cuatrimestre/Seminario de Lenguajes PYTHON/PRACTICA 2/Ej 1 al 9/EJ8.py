string= input ("Ingrese una palabra o frase")
string=string.lower()
string=string.replace(' ','')
letras=[]
b=True
for letra in string:
    if not letra in letras:
        letras.append(letra)
    else:
        print ("La frase no es un heterograma")
        b=False
        break

if b:
    print ("La frase o palabra es un heterograma")