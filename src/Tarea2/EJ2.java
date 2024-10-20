package Tarea2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EJ2 {
    public static void main(String[] args) {
        try {
            String[] comando = {"cmd", "/c", "ls"};
            ProcessBuilder pb = new ProcessBuilder(comando);
//            pb.inheritIO();
            Process p = pb.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.err.println(line);
                }
            }

            int codigoSalida = p.waitFor();
            System.out.println("El código de salida es: " + codigoSalida);
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando.");
        } catch (InterruptedException e) {
            System.out.println("La ejecución del proceso fue interrumpida.");
        }
    }
}
