names = """ Agustin, Yanina, Andrés, Ariadna, Bautista, CAROLINA,
CESAR, David, Diego, Dolores, DYLAN, ELIANA, Emanuel, Fabián, Noelia,
Francisca, FEDERICO, Fernanda, GONZALO, Nancy """

goals = [0, 10, 4, 0, 5, 14, 0, 0, 7, 2, 1, 1, 1, 5, 6, 1, 1, 2, 0, 11]

goals_avoided = [0, 2, 0, 0, 5, 2, 0, 0, 1, 2, 0, 5, 5, 0, 1, 0, 2, 3, 0, 0]

assists = [0, 5, 1, 0, 5, 2, 0, 0, 1, 2, 1, 5, 5, 0, 1, 0, 2, 3, 1,0]

#INCISO 1
from functions import generate_structure  

players=generate_structure(names,goals,goals_avoided,assists)

#INCISO 2
from functions import getgoleador
goleador=getgoleador(players)
print (f"El/la goleador/a fue {goleador[0]} con {goleador[1]} goles")

#INCISO 3
from functions import getmip
print (f"El/la jugador/a mas influyente del torneo fue {getmip(players)}")

#INCISO 4
from functions import getpromediogeneral
print (f"El promedio de goles por partido del equipo es de {getpromediogeneral(goals)}")

#INCISO 5
from functions import promedypermatch
promedy=promedypermatch(goals)
print (f"El promedio de goles por partido del goleador es de: {promedy}")

