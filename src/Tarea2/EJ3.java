package Tarea2;

import java.io.*;

public class EJ3 {
    public static void main(String[] args) {
        try {
            String[] comando = {"cmd"};
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
                 BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                bw.write("echo Ejercicio 3 Tarea 2");
                bw.newLine();
                bw.flush();

                bw.write("exit");
                bw.newLine();
                bw.flush();

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

            System.out.println(p.waitFor());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
