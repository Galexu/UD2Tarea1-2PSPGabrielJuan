package Tarea1;

import java.io.File;
import java.io.IOException;

public class EJ6 {
    public static void main(String[] args) {
        String[] comandoCrear = {"cmd", "/c", "mkdir", "nuevo_directorio"};
        String[] comandoEliminar = {"cmd", "/c", "rmdir", "nuevo_directorio"};

        try {
            ProcessBuilder crearPb = new ProcessBuilder(comandoCrear);
            Process procesoCrear = crearPb.start();
            int salidaCreacion = procesoCrear.waitFor();
            System.out.println("Codigo de retorno de creacion: " + salidaCreacion);

            Thread.sleep(1000);
            File f = new File("C:\\Users\\Galex\\IdeaProjects\\ADA\\UD1\\Tarea 1 UD2\\nuevo_directorio");
            System.out.println("Existe nuevo_directorio tras la creacion? " + (f.exists() ? "Sí existe" : "No existe"));

            ProcessBuilder borrarPb = new ProcessBuilder(comandoEliminar);
            Process procesoBorrar = borrarPb.start();
            int salidaEliminacion = procesoBorrar.waitFor();
            System.out.println("Codigo de retorno de eliminacion: " + salidaEliminacion);

            Thread.sleep(1000);
            System.out.println("Existe nuevo_directorio tras la eliminacion? " + (f.exists() ? "Sí existe" : "No existe"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
