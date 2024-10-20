package Tarea2;

import java.io.*;

public class EJ5 {
    public static void main(String[] args) {
        //en windows cmd, en linux bash
        ProcessBuilder pb = new ProcessBuilder(new String[]{"cmd"});
        Process process = null;

        try {
            process = pb.start();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                 BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                bw.write("dir");
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
            System.out.println(process.waitFor());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
