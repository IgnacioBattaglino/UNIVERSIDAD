word = input("Ingresá una palabra: ")
if "a" in word and "n" in word:
    print("La palabra contiene tanto la letra 'a' como la letra 'n'.")
elif "a" in word:
    print("La palabra contiene solo la letra 'a'.")
elif "n" in word:
    print("La palabra contiene solo la letra 'n'.")
else:
    print("La palabra no contiene ni la letra 'a' ni la letra 'n'.")
