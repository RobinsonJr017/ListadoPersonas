import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        // Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        // Empezamos con el menu
        var salir = false;
        while(!salir){
            mostrarMenu();
            try {
                salir = ejecutarOpciones(consola, personas);
            } catch (Exception e) {
                System.out.println("Ocurrio un Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        //Mostrar Menu
        System.out.println("""
                *** Listado de Personas ***
                1. Agregar 
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opcion corrrecta?:  ");
    }

    private static boolean ejecutarOpciones(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //Verificamos la opcion proporcionada
        switch (opcion) {
            case 1 -> { //agregar Personas
                System.out.print("Ingrese el nombre de la persona: ");
                var nombre = consola.nextLine();
                System.out.print("Ingrese el telefono de la persona: ");
                var telefono = consola.nextLine();
                System.out.print("Ingrese el email de la persona: ");
                var email = consola.nextLine();
                var persona = new Persona(nombre, telefono, email);
                //Agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos ");
            } // fin caso 1

            case 2 -> { // Lista de personas
                System.out.println("Listado de Persona");
                //Mejora usando lamba y metodo de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }

            case 3 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion Erronea: " + opcion);
        } // Fin switch
        return salir;
    }
}
