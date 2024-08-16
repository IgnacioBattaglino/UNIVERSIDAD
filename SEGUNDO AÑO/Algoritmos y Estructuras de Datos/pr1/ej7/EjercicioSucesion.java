package tp1.ej7;
import java.util.*;

public class EjercicioSucesion {

    public static List<Integer> calcularSucesion(int n) {
        List<Integer> list = new ArrayList<>();
        calcularSucesionRecursivo(n, list); // Llamada inicial para calcular la sucesión
        return list;
    }

    private static void calcularSucesionRecursivo(int n, List<Integer> list) {
        list.add(n); // Agregar el número actual a la lista

        if (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            calcularSucesionRecursivo(n, list); // Llamada recursiva con el nuevo valor de n
        }
    }
    
    public static void invertirArrayList(List<Integer> lista) {
        invertirArrayListRecursivo(lista, 0, lista.size() - 1);
    }

    private static void invertirArrayListRecursivo(List<Integer> lista, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int aux = lista.get(inicio);
        lista.set(inicio, lista.get(fin));
        lista.set(fin, aux);

        invertirArrayListRecursivo(lista, inicio + 1, fin - 1);
    }
    

    public static void main(String[] args) {
    	List lista= calcularSucesion(6);
        System.out.println(lista);
        invertirArrayList (lista);
        System.out.println(lista);
        
    }
}
