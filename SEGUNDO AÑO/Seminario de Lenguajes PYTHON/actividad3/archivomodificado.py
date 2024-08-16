def my_function(file_name, *artists):
    data = json.load(file_name)
    if artists:
        my_songs = filter(lambda x: x["nombre"] in artists, data)
    else:
        my_songs = filter(lambda x: x["nombre"] == "Panza", data)
    return my_songs

"""
b) La funcion se puede invocar con un parametro obligatorio (fileName) y con un 
parametro opcional que es artists, el cual puede recibir una cantidad de 
elementos ilimitados, los cuales son almacenados en una tupla. 
"""


from pathlib import Path
import json
file_name = Path('archivos') / 'musica.json'
try:
    with open(file_name) as file:
        my_songs = my_function(file)
        for song in my_songs:
            print(song)
except:
    print(f'Hubo problemas con {file_name}')

"""
d) Para que se muestre el mensaje cuando el codigo no presente ninguna excepcion,
se deberia agregar el 'print(mensaje)' al final del codigo try (antes del except:).
De esta manera se mostraria el mensaje siempre que no se presente ninguna excepcion.

e) La variable adele_songs no existe, asumo que se refiere a my_songs.
my_songs es un objeto de tipo filtro, ya que lo devuelve la funcion filter.
Para poder acceder a su contenido en otras partes del codigo y recorrerlo
mas de una vez, lo que hay que hacer es "castear" el objeto en una lista con
nombre_lista= list(my_songs).
"""
