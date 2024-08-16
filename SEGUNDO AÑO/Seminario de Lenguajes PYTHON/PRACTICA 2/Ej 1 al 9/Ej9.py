valores_scrabble = {
    ('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'): 1,
    ('D', 'G'): 2,
    ('B', 'C', 'M', 'P'): 3,
    ('F', 'H', 'V', 'W', 'Y'): 4,
    ('K',): 5,
    ('J', 'X'): 8,
    ('Q', 'Z'): 10
}

palabra = input("Ingrese una palabra en mayúsculas: ")

valor_total = 0

for letra in palabra:
    for letras_grupo, valor_letra in valores_scrabble.items():
        if letra in letras_grupo:
            valor_total += valor_letra
            break

print("El valor de la palabra", palabra, "en el juego Scrabble es:", valor_total)
