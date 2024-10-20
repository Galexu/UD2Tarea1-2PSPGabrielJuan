package Tarea2;

import java.io.*;
import java.util.Scanner;

public class EJ6 {
    public static void main(String[] args) {
//        nslookupInherit();
        nslookupStream();
    }

    private static void nslookupInherit() {
        String[] comando = {"cmd", "/c", "nslookup"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        System.out.println("Recuerde que para salir del programa debe escribir exit.");

        try {
            pb.inheritIO();
            Process p = pb.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void nslookupStream() {
        System.out.println("Recuerde que para salir del programa debe escribir exit.");
        Scanner sc = new Scanner(System.in);
        String b = "";

        try {
            while (!b.contains("exit")) {
                System.out.print("Ingrese la direccion a buscar: ");
                b = sc.nextLine();
                String[] comando = {"cmd", "/c", "nslookup", b};
                ProcessBuilder pb = new ProcessBuilder(comando);
                Process p = pb.start();
                String line;

                try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                }

                p.destroy();
            }
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //no consegui hacerlo completamente con el writer y reader a la vez, funciona la mitad de veces solamente debido al while y el line.trim.isempty terminando el bucle antes
    //de que muestre todas las lineas ya que pilla una lina vacia, haciendo que solo funcione la segunda busqueda de cada 2, con el try-with-resources me cerraba los flujos
    //y tambien me daba error.
//        try {
//            Process p = pb.start();
//
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
//            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//
//            String busqueda = "";
//
//            String line;
//            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
//                System.out.println(line);
//            }
//
//            while (!busqueda.equalsIgnoreCase("exit")) {
//                System.out.println();
//                System.out.print("> ");
//                busqueda = sc.nextLine();
//
//                bw.write(busqueda);
//                bw.newLine();
//                bw.flush();
//
//                while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
//                    System.out.println(line);
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

}
