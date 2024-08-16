import random

# Lista de palabras posibles
words = ["python", "programación", "computadora", "código", "desarrollo", "inteligencia"]
# Elegir una palabra al azar
secret_word = random.choice(words)
# Número máximo de intentos permitidos
max_attempts = 10
# Lista para almacenar las letras adivinadas
guessed_letters = []
vocales= ["a","e","i","o","u","á","é","ú","í","ó"]

menu="4"

while menu not in (["1","2","3"]):

    print("¡Bienvenido al juego de adivinanzas!")
    print("""Elige un nivel de dificultad! 
    Presiona [1] para FACIL  
    Presiona [2] para MEDIO
    Presiona [3] para DIFICIL""")

    menu = input ()

    if menu == "1": 
        guessed_letters.extend (vocales)

    elif menu == "2":
        guessed_letters.append(secret_word[0]) 
        guessed_letters.append (secret_word[-1])

    elif menu == "3":
        word_displayed= "-" * len(secret_word)

    else: 
        print ("Debe ingresar una opcion valida.")
    
letters= []
for char in secret_word:
    if char in guessed_letters:
        letters.append(char)
    else:
        letters.append("_")  

word_displayed = "".join(letters)

print("Estoy pensando en una palabra. ¿Puedes adivinar cuál es?")
letters = []

# Mostrar la palabra parcialmente adivinada
print(f"Palabra: {word_displayed}")

fallos=0

while fallos<max_attempts:
    # Pedir al jugador que ingrese una letra
    letter = input("Ingresa una letra: ").lower()

    # Corregir bug del caracter vacio.
    if letter == "" :
        print ("Debes ingresar una letra!")
        continue

     # Verificar si la letra ya ha sido adivinada
    if letter in guessed_letters:
        print("Esa letra ya la usaste! Intenta con otra.")
        continue

    # Agregar la letra a la lista de letras adivinadas
    guessed_letters.append(letter)

    # Verificar si la letra está en la palabra secreta
    if letter in secret_word:
        print("¡Bien hecho! La letra está en la palabra.")
    else:
        print("Lo siento, la letra no está en la palabra.")
        fallos+=1 
    # Mostrar la palabra parcialmente adivinada
    letters = []
    for letter in secret_word:
        if letter in guessed_letters:
            letters.append(letter)
        else:
            letters.append("_")

    word_displayed = "".join(letters)
    print(f"Palabra: {word_displayed}")
    # Verificar si se ha adivinado la palabra completa
    if word_displayed == secret_word:
        print(f"¡Felicidades! Has adivinado la palabra secreta: {secret_word}")
        break
else:
    print(f"¡Oh no! Has agotado tus {max_attempts} intentos.")
    print(f"La palabra secreta era: {secret_word}")