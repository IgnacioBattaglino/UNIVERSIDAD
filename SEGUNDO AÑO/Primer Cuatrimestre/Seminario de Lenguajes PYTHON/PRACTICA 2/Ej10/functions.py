def generate_structure (names:str, goals:tuple, goals_avoided:tuple, assists:tuple):
  """ 
  Genera un diccionario con la información de los jugadores.
  Parameters:
  names (str): Una cadena que contiene los nombres de los jugadores separados por comas.
  goals (tuple): Una lista de enteros que representa la cantidad de goles marcados por cada jugador.
  goals_avoided (tuple): Una lista de enteros que representa la cantidad de goles evitados por cada jugador.
  assists (tuple): Una lista de enteros que representa la cantidad de asistencias realizadas por cada jugador.

  Returns:
  players_info(dict): Un diccionario donde las claves son los nombres de los jugadores y los valores son diccionarios
  con la información de cada jugador, incluyendo 'Goles', 'Goles evitados' y 'Asistencias'.
  """

  names= tuple(map(lambda name:  name.strip() , names.split(',')))
  combined_data = tuple(zip(names, goals, goals_avoided, assists))
  players_info = dict(map(lambda data: (data[0], {'Goles': data[1], 'Goles evitados': data[2], 'Asistencias': data[3]}), combined_data))

  return players_info

def getgoleador (structure:dict):
  """
  Parameters:
  structure (dict): estructura con los jugadores y sus respectivos goles.
  Returns:
  goleador (str): Nombre del jugador con más goles.
  maxgoles (int): Numero maximo de goles.
  """

  maxgoleador= max(structure.items(), key= lambda elem: elem[1]['Goles'])
  goleador= maxgoleador[0] 
  maxgoles= maxgoleador[1]['Goles']
  return goleador, maxgoles 

def getmip (structure:dict):
  """
  Parameters:
  structure (dict): estructura con los jugadores y sus respectivos goles.
  Returns:
  str: Nombre del jugador mas influyente (most influential player).
  """

  maxpoints=0
  mip = ""
  for jugador,info in structure.items():
    points= info.get ('Goles') * 1.5 +  info.get ('Goles evitados') * 1.25 + info.get ('Asistencias')
    if points> maxpoints: 
      maxpoints=points
      mip=jugador
  
  return mip

def getpromediogeneral (goals:tuple):
  """
  Parameters:
  goals (tuple): Una lista de enteros que representa la cantidad de goles marcados por cada jugador.
  Returns:
  promedy (float): promedio de goles por partido del equipo en general. 
  """

  promedy=sum(goals) / 25 
  return promedy

def promedypermatch (goals:tuple):
  promedy= max(goals)/25
  return promedy