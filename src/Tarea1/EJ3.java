package Tarea1;

import java.io.IOException;

public class EJ3 {
    public static void main(String[] args) {
        try {
            String[] comando = {"cmd", "/c", "ls"};
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();
            int codigoSalida = p.waitFor();
            System.out.println("El codigo de salida es: " + codigoSalida);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
