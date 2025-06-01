import java.io.*;
import java.util.*;

public class SumaSecuencial {
    public static void main(String[] args) throws IOException {
        List<Integer> numeros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("numeros.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }
        }


        long inicio = System.nanoTime();

        long sumaTotal = 0;
        for (int n : numeros) {
            sumaTotal += n;
        }

        long fin = System.nanoTime();
        double tiempo = (fin - inicio) / 1_000_000_000.0;

        System.out.println("Suma total: " + sumaTotal);
        System.out.println("Tiempo secuencial: " + tiempo + " segundos");
    }
}
