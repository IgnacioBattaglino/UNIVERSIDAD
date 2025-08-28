frase= input("Ingrese una frase").lower()
string= input ("Ingrese un string").lower()
frase=frase.split()
contador=0

for palabra in frase:
    if string in palabra:
        contador+=1

print("Cantidad de veces encontrado: ", contador)
