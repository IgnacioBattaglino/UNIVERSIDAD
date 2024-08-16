text = """ La brecha salarial alcanzó el 27,7%: las mujeres ocupadas
debieron trabajar 8 días y 10 horas más que los varones ocupados para
ganar lo mismo que ellos en un mes. """

text_split= text.split()
uppers=0
lowers=0
specials=0

for palabra in text:
    for letra in palabra:
        if not letra.isalpha():
            specials+=1
        elif letra.isupper():
            uppers+=1
        else:
            lowers+=1

text=text.lower()
text_split=text.split()

words=[]

for palabra in text_split:
    if not palabra in words:
        words.append(palabra)

print ("Mayusculas: ", uppers)
print ("Minusculas: ", lowers)
print ("Caracteres no letras: ", specials)
print (words)
print ("Palabras: ", len(words))

