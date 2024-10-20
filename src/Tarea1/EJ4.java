package Tarea1;

import java.io.IOException;

public class EJ4 {
    public static void main(String[] args) {
        try {
            String[] comando = {"blocdenotas"};
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();
            int codigoSalida = p.waitFor();
            System.out.println("El código de salida es: " + codigoSalida);
        } catch (IOException e) {
            System.out.println("Error al ejecutar el comando.");
        } catch (InterruptedException e) {
            System.out.println("La ejecución del proceso fue interrumpida.");
        }
    }
}
