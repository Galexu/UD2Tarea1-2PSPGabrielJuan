package Tarea1;

import java.io.IOException;

public class EJ7 {
    public static void main(String[] args) {
        try {
            String[] comando = {"cmd", "/c", "ping 8.8.8.8 -n 20"};

            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();

            while (p.isAlive()) {
                System.out.println("El comando sigue activo");
                Thread.sleep(3000);
            }

            System.out.println("Termino la ejecucion del comando");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
