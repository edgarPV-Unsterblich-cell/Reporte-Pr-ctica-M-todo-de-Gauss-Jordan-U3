# Práctica: Método de Gauss-Jordan en Java

**Asignatura:** SCC-1017 Métodos Numéricos (Unidad 3)  
**Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)

## Estructura Modular del Proyecto
- `Gauss.java`: Contiene `eliminacionGaussiana(matriz)` para la triangulación superior sobre la matriz aumentada.
- `GaussJordan.java`: Reutiliza `Gauss.eliminacionGaussiana(matriz)`, normaliza los pivotes a `1`, realiza el barrido superior para formar la matriz identidad y lee el vector solución desde `matriz[i][n]`.
- `MainGaussJordan.java`: Define la matriz aumentada de prueba y presenta en consola la matriz resultante y las soluciones.

## Compilación y Ejecución
```bash
javac *.java
java MainGaussJordan
