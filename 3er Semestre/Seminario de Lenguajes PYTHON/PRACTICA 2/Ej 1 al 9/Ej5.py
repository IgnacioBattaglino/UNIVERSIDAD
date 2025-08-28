article = """ título: Experiences in Developing a Distributed Agentbased Modeling Toolkit with Python Version 3
resumen: Distributed agent-based modeling (ABM) on high-performance
computing resources provides the promise of capturing unprecedented
details of large-scale complex systems. However, the specialized
knowledge required for developing such ABMs creates barriers to wider
adoption and utilization. Here we present our experiences in
developing an initial implementation of Repast4Py, a Python-based
distributed ABM toolkit. We build on our experiences in developing ABM
toolkits, including Repast for High Performance Computing (Repast
HPC), to identify the key elements of a useful distributed ABM
toolkit. We leverage the Numba, NumPy, and PyTorch packages and the
En este ejemplo se debe informar:
Python C-API to create a scalable modeling system that can exploit the 
largest HPC resources and emerging computing architectures. """

from collections import Counter

titulo, resumen = article.split('\n', 1)

if len(titulo)>10:
    print("Titulo: not ok")
resumen= resumen.split('.')
cnt=Counter()
for sentence in resumen:
    if len(sentence)<12:
        cnt["facil de leer"]+=1
    elif len(sentence)<17:
        cnt ["aceptable para leer"]+=1
    elif len(sentence)<25:
        cnt ["dificil de leer"]+=1
    else:
        cnt ["muy dificil"]+=1

print ("Cantidad de oraciones faciles de leer: ", cnt["facil de leer"])
print ("Cantidad de oraciones aceptables para leer: ", cnt["aceptable para leer"])
print ("Cantidad de oraciones dificiles de leer: ", cnt["dificil de leer"])
print ("Cantidad de oraciones muy dificiles de leer: ", cnt["muy dificil"])