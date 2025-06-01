import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class SumaParalela {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        int hilos = Integer.parseInt(args[0]);
        List<Integer> numeros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("numeros.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(hilos);
        List<Future<Long>> resultados = new ArrayList<>();

        int tamano = numeros.size();
        int tamanoBloque = tamano / hilos;

        long inicio = System.nanoTime();

        for (int i = 0; i < hilos; i++) {
            int inicioBloque = i * tamanoBloque;
            int finBloque = (i == hilos - 1) ? tamano : inicioBloque + tamanoBloque;
            List<Integer> sublista = numeros.subList(inicioBloque, finBloque);

            resultados.add(executor.submit(() -> {
                long sumaParcial = 0;
                for (int n : sublista) {
                    sumaParcial += n;
                }
                return sumaParcial;
            }));
        }

        long sumaTotal = 0;
        for (Future<Long> resultado : resultados) {
            sumaTotal += resultado.get();
        }

        long fin = System.nanoTime();
        double tiempo = (fin - inicio) / 1_000_000_000.0;

        executor.shutdown();

        System.out.println("Suma total: " + sumaTotal);
        System.out.println("Tiempo paralelo con " + hilos + " hilos (s): " + tiempo);
    }
}
