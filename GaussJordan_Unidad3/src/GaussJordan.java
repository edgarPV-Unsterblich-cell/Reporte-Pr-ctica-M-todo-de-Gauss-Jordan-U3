//By:Edgar E PV
public class GaussJordan {

    // Transforma la matriz en identidad y devuelve directamente el vector solucion
    public static double[] resolver(double[][] matriz) {
        // Validar que la matriz exista y tenga dimensiones n x (n + 1)
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz no puede estar vacia.");
        }

        int n = matriz.length;
        for (double[] fila : matriz) {
            if (fila == null || fila.length != n + 1) {
                throw new IllegalArgumentException("La matriz debe ser aumentada de dimension n x (n + 1).");
            }
        }

        // Paso 1: Reutilizar el metodo de triangulacion superior de la clase Gauss
        Gauss.eliminacionGaussiana(matriz);

        // Paso 2: Recorrer de abajo hacia arriba para normalizar pivotes y eliminar arriba
        for (int i = n - 1; i >= 0; i--) {
            double pivote = matriz[i][i];
            if (Math.abs(pivote) < 1e-12) {
                throw new ArithmeticException("El sistema no tiene solucion unica (pivote cero en fila " + i + ").");
            }

            // Dividir toda la fila entre el pivote para volverlo 1.0
            for (int j = i; j <= n; j++) {
                matriz[i][j] /= pivote;
            }
            matriz[i][i] = 1.0;

            // Hacer ceros en las posiciones superiores de la columna del pivote
            for (int filaArriba = i - 1; filaArriba >= 0; filaArriba--) {
                double factor = matriz[filaArriba][i];
                for (int j = i; j <= n; j++) {
                    matriz[filaArriba][j] -= factor * matriz[i][j];
                }
                matriz[filaArriba][i] = 0.0;
            }
        }

        // Paso 3: Leer la solucion directamente desde la ultima columna (matriz[i][n])
        double[] solucion = new double[n];
        for (int i = 0; i < n; i++) {
            solucion[i] = matriz[i][n];
        }
        return solucion;
    }
}