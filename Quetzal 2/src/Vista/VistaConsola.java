package Vista;
import java.util.Scanner;

public class VistaConsola {
    private final Scanner scanner;
   
    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("=== Defensa de Quetzal 2 ===");
        System.out.println("1. Listar todos los módulos");
        System.out.println("2. Buscar módulo");
        System.out.println("3. Catálogo ordenado por costo");
        System.out.println("4. Avanzar un ciclo");
        System.out.println("5. Resumen de comunicaciones");
        System.out.println("0. Salir");
    }

    public int LeerOpcion() {

        while (true) {
            System.out.print("Ingrese una opción: ");
            String input = scanner.nextLine();
            
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Por favor, ingrese un número.");
            }
        }

    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
