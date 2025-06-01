# Practica #1 -- Paralelización de Algoritmos y Análisis de Rendimiento

## Archivos importantes en el Repositorio:
### Primero entramos a src, luego a main y luego a java, ahi encontraremos los siguientes archivos en los que se estuvo trabajando:

numeros.txt: Archivo con 1,000,000 números aleatorios

GeneradorArchivo.java: Crea el archivo de entrada

SumaSecuencial.java: Versión secuencial

SumaParalela.java:  Versión paralela con hilos

### Para compilar los programas seria correr estos comandos, teniendo en cuenta que debemos estar en el directorio correcto
javac SumaSecuencial.java

javac SumaParalela.java

### Luego podemos correr el programa
java SumaSecuencial

java SumaParalela 2

java SumaParalela 4

java SumaParalela 8

java SumaParalela 16

### Ejemplo de Salida
Secuencial:

Suma total: 5001384290

Tiempo secuencial con 1 hilo(s): 0.00390063 segundos

Paralela:

Suma total: 5001384290

Tiempo paralelo con 4 hilos (s): 0.01405946 segundos

Al realizar la suma paralela del arreglo, se logró una mejora significativa en el tiempo de ejecución. Pero, de igual manera, se observa una disminución en la eficiencia conforme se aumentan los hilos.
