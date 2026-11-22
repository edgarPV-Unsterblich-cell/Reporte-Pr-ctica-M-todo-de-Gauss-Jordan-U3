//By:Edgar E PV
public class Gauss {

    // Convierte la matriz aumentada en forma triangular superior modificandola por referencia
    public static void eliminacionGaussiana(double[][] matriz) {
        int n = matriz.length; // Numero de ecuaciones (filas)

        // Recorrer cada columna como posible pivote
        for (int col = 0; col < n; col++) {
            int filaPivote = col;
            double maxValor = Math.abs(matriz[col][col]);

            // Buscar el mayor valor absoluto debajo del pivote para mayor estabilidad numerica
            for (int fila = col + 1; fila < n; fila++) {
                double actual = Math.abs(matriz[fila][col]);
                if (actual > maxValor) {
                    maxValor = actual;
                    filaPivote = fila;
                }
            }

            // Validar que el pivote no sea cero (sistema singular o sin solucion unica)
            if (Math.abs(matriz[filaPivote][col]) < 1e-12) {
                throw new ArithmeticException("Pivote nulo o singular en la columna " + col);
            }

            // Intercambiar la fila actual con la fila del mejor pivote si es necesario
            if (filaPivote != col) {
                double[] temp = matriz[col];
                matriz[col] = matriz[filaPivote];
                matriz[filaPivote] = temp;
            }

            // Eliminar los elementos por debajo del pivote en la columna actual
            for (int fila = col + 1; fila < n; fila++) {
                double factor = matriz[fila][col] / matriz[col][col];
                for (int k = col; k <= n; k++) {
                    matriz[fila][k] -= factor * matriz[col][k];
                }
            }
        }
    }
}