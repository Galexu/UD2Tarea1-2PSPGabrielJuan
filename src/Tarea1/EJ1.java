package Tarea1;

import java.io.IOException;

public class EJ1 {
    public static void main(String[] args) {
        try {
            String[] comando = {"calc"};
            Runtime.getRuntime().exec(comando);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
