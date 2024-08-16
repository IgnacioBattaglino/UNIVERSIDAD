import json
from pathlib import Path

def my_function(fileName):
    data = json.load(fileName)
    my_songs = filter(lambda x: x["nombre"] == "Panza", data)
    return my_songs


file_name = Path('archivos') / 'musica.json'
try:
    with open(file_name) as file:
        my_songs = my_function(file)
        for song in my_songs:
            print(song)
except:
    print(f'Hubo problemas con {file_name}')
