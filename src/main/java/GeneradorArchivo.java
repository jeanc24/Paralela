import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorArchivo {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("numeros.txt");
        Random rand = new Random();

        for (int i = 0; i < 1_000_000; i++) {
            int numero = rand.nextInt(10_000) + 1; // Entre 1 y 10,000
            writer.write(numero + "\n");
        }

        writer.close();
        System.out.println("Archivo generado exitosamente.");
    }
}
