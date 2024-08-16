import pandas as pd

file_route = "lagos_arg.csv"

def my_function(data, *args):
    filtered_data = data[(data['Ubicación'].isin(args)) & (data['Superficie (km²)']>=50)]
    result = filtered_data.groupby ('Ubicación')['Superficie (km²)'].max()
    result= result.to_dict()

    return result

data= pd.read_csv (file_route)

result = my_function(data, "Chubut", "Río Negro / Neuquén")

print(result)

# d:
# print (data.shape)

# VENTAJAS:
# 1) Facilidad para filtrar datos sin necesidad de corregir tipos de datos ya que pandas lo hace automaticamente ni iterar sobre cada fila. 
# Ademas es mas simple y facil de comprender al leer el codigo, a diferencia de utilizar filter y lambda que lo complejizan a la hora de leer.

# 2) No es necesario cargar todo el archivo csv en memoria con list (reader) como en csv, tampoco es necesario el
# uso de for para iterar sobre el archivo. Pandas es mucho mas eficiente con su amplia gama de funciones como groupby.


