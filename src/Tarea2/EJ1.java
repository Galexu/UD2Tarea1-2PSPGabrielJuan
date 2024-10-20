package Tarea2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.classfile.constantpool.PoolEntry;

public class EJ1 {
    public static void main(String[] args) {
        try {
            String[] comando = {"cmd", "/c", "echo Hello World"};
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();

//            pb.inheritIO();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            p.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
