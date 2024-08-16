menu= "5"
inventory= {}
while menu != 4:
    menu= input (""" Elija una de las siguientes opciones:
           [1] Agregar un producto al inventario.
           [2] Eliminar un producto exitente del inventario.
           [3] Mostrar el inventario actual.
           [4] Salir del programa.
           """)
    if menu=="1":
        pname = input ("Ingrese el nombre del producto. (Si el producto ya esta, se sumaran las unidades existentes con las unidades ingresadas)")
        pcant = input ("Ingrese la cantidad de unidades.")
        if pname in inventory:
            inventory[pname]= str(int(inventory[pname]) + int(pcant))
        else:
            inventory[pname]= pcant
    elif menu =="2":
        pname = input ("Ingrese el nombre del producto que quiere eliminar")
        if pname in inventory:
            del(inventory[pname])
        else: 
            print ("Ese producto no se encuentra en el inventario");
    elif menu=="3":
        print (inventory)     
    elif menu== "4": 
        print ("Programa finalizado.")
        import sys
        sys.exit(0)
    else: 
        print ("Porfavor ingrese una opcion valida.")
    