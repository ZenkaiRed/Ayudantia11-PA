public class Main {
    public static void main(String[] args) {

        int[] arrSum = {1, 2, 3, 4, 5};

        int[] arrBinary = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(suma(arrSum, 0, 4));

        System.out.println(potencia(10, -1));


        System.out.println("Hello world!");
    }

    public static int suma(int[] arr, int inicio, int fin) {

        // No puede iniciar en una posición mayor al fin.
        if (inicio > fin) {
            throw new IllegalArgumentException("El inicio del arreglo no puede ser mayor al fin.");
        }

        // Caso base: si el arreglo tiene un solo elemento
        if (inicio == fin) {
            return arr[inicio];
        }

        // Encuentra el punto medio del arreglo
        int medio = (inicio + fin) / 2;

        // Divide el arreglo y conquista recursivamente
        int sumaIzquierda = suma(arr, inicio, medio);
        int sumaDerecha = suma(arr, medio + 1, fin);

        // Combina las soluciones parciales
        return sumaIzquierda + sumaDerecha;
    }

    private static int busquedaBinaria(int[] arr, int objetivo, int inicio, int fin) {

        // Caso base: si el inicio es mayor que el fin, el objetivo no está en el arreglo
        if (inicio > fin) {
            return -1;
        }

        // Encuentra el punto medio del arreglo
        int medio = (inicio + fin) / 2;

        // Si el elemento medio es el objetivo, devuelve la posición
        if (arr[medio] == objetivo) {
            return medio;
        }

        // Si el objetivo es menor que el elemento medio, busca en la mitad izquierda
        if (arr[medio] > objetivo) {
            return busquedaBinaria(arr, objetivo, inicio, medio - 1);
        }

        // Si el objetivo es mayor que el elemento medio, busca en la mitad derecha
        return busquedaBinaria(arr, objetivo, medio + 1, fin);
    }

    private static double potencia(double base, int exponente) {
        // Caso base: cualquier número elevado a la potencia 0 es 1
        if (exponente == 0) {
            return 1;
        }

        // Si el exponente es negativo, convierte el problema a un exponente positivo
        if (exponente < 0) {
            return 1 / potencia(base, -exponente);
        }

        // Si el exponente es par, divide el problema en dos subproblemas iguales
        if (exponente % 2 == 0) {
            double mitad = potencia(base, exponente / 2);
            return mitad * mitad;

        } else {
            // Si el exponente es impar, reduce el problema y ajusta el resultado
            return base * potencia(base, exponente - 1);
        }
    }
}