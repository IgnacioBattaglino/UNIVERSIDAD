jupyter_info = """ JupyterLab is a web-based interactive development
environment for Jupyter notebooks, code, and data. JupyterLab is
flexible: configure and arrange the user interface to support a wide
range of workflows in data science, scientific computing, and machine
learning. JupyterLab is extensible and modular: write plugins that add
new components and integrate with existing ones. """

letra= input("Ingrese una letra")
if letra.isalpha():
    already_used_words=[]
    special_characters=(':','.',',')
    for character in special_characters:
        if character in jupyter_info:
            jupyter_info=jupyter_info.replace(character,'')
    words=jupyter_info.split()        
    for word in words: 
        if not word in already_used_words:
            already_used_words.append(word)
            for letter in word:
                if letter==letra:
                    print(word)
                    break
else:
    print ("Error: lo ingresado no es una letra")    
