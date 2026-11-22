//By:Edgar E PV
public class MainGaussJordan {

    // Define la matriz aumentada [A | b] del sistema a resolver
    public static double[][] definirMatrizAumentada() {
        return new double[][] {
                { 2.0,  1.0, -1.0,   8.0},
                {-3.0, -1.0,  2.0, -11.0},
                {-2.0,  1.0,  2.0,  -3.0}
        };
    }

    // Imprime la matriz aumentada formateada en consola
    public static void imprimirMatrizAumentada(double[][] matriz) {
        int n = matriz.length;
        int cols = matriz[0].length;
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                if (j == n) {
                    System.out.print("| "); // Separador visual antes de los terminos independientes
                }
                // Evita mostrar "-0.00" por precision de punto flotante
                double valor = Math.abs(matriz[i][j]) < 1e-12 ? 0.0 : matriz[i][j];
                System.out.printf("%6.2f ", valor);
            }
            System.out.println("]");
        }
        System.out.println();
    }

    // Muestra el valor final de cada incognita
    public static void imprimirSolucion(double[] solucion) {
        System.out.println("Solucion directa del sistema:");
        for (int i = 0; i < solucion.length; i++) {
            System.out.printf("x%d = %.4f%n", i + 1, solucion[i]);
        }
    }

    // Punto de entrada para ejecutar el programa
    public static void main(String[] args) {
        System.out.println("=== METODO DE GAUSS-JORDAN (MODULAR) ===");
        double[][] matriz = definirMatrizAumentada();

        System.out.println("Matriz aumentada inicial:");
        imprimirMatrizAumentada(matriz);

        // Resuelve el sistema modificando la matriz hasta dejarla en forma identidad
        double[] solucion = GaussJordan.resolver(matriz);

        System.out.println("Matriz final reducida (forma identidad):");
        imprimirMatrizAumentada(matriz);

        imprimirSolucion(solucion);
    }
}