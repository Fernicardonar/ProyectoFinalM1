import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception { 

        /*Aquí se establece el menú con un do while para que se repita hasta que el usuario haga el ciclo completo de consulta
        del estudiante o decida salir, como se vio en clases anteriores.*/

        var imput = new Scanner(System.in);
        var salir = false;
            
        do {          
            System.out.println("""
            --- Bienvenido al Sistema de Registro de Estudiantes ---

            1. Registrar datos de un estudiante
            2. Mostrar datos del estudiante actual
            3. Calcular promedio de notas del estudiante actual
            0. Salir

            Ingrese su opción: """);
            int opcion = imput.nextInt();
            imput.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1: 
                    registrarEstudiante(imput);
                    break;
                case 2: 
                    mostrarDatosEstudiante(imput);
                    break;
                case 3:
                    calcularPromedioNotas(imput);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Revise su selección.");
                    break;
            }

            }while (!salir);
        System.out.println("Espero haber sido de ayuda, ¡hasta luego!");
        imput.close();       
    ;
    }

    //Aquí establezco las variables que se reuieren en modo estático, esto permite que los métodos tenga acceso a los datos

    private static String nombreEstudiante = "";
    private static String apellidoEstudiante = "";
    private static double nota1 = 0.00;
    private static double nota2 = 0.00;
    private static double nota3 = 0.00;
    

    private static void registrarEstudiante(Scanner imput) {
        System.out.println("Registro de estudiante activo");
        System.out.print("Ingrese el nombre del estudiante: ");
        nombreEstudiante = imput.nextLine();
        if (nombreEstudiante.isEmpty()) {
            System.out.println("El nombre del estudiante no puede estar vacío.");
            return; // Sale del método si el nombre está vacío
        }
        System.out.print("Ingrese el apellido del estudiante: ");
        apellidoEstudiante = imput.nextLine();
        if (apellidoEstudiante.isEmpty()) {
            System.out.println("El apellido del estudiante no puede estar vacío.");
            return; // Sale del método si el apellido está vacío
        }
        nota1 = solicitarNota(imput, "primera");
        nota2 = solicitarNota(imput, "segunda");
        nota3 = solicitarNota(imput, "tercera");


        System.out.println("Se han registrado los datos del estudiante correctamente.");
    }

    private static double solicitarNota(Scanner scanner, String numeroNota) {
        double nota;
        
        do {
            System.out.print("Ingrese la " + numeroNota + " nota (0-100): ");
            
            // Desafío adicional: Validar que sea un número
            try {
                nota = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                
                if (!validarNota(nota)) {
                    System.out.println("Error: La nota debe estar entre 0 y 100.");
                }
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar el buffer
                nota = -1; // Valor inválido para repetir el bucle
            }
        } while (!validarNota(nota));
        
        return nota;
    }

    private static void mostrarDatosEstudiante(Scanner imput) {
        if (nombreEstudiante.isEmpty() || apellidoEstudiante.isEmpty()) {
            System.out.println("No hay datos del estudiante registrados.");
        } else {
            System.out.println("Datos del estudiante actual:");
            System.out.println("Nombre y apellido: " + nombreEstudiante + " " + apellidoEstudiante);           
            System.out.printf("Notas: %.2f, %.2f, %.2f%n", nota1, nota2, nota3);
        }        
    }

    private static void calcularPromedioNotas(Scanner imput) {
        if (nombreEstudiante.isEmpty() || apellidoEstudiante.isEmpty()) {
            System.out.println("No hay datos del estudiante registrados.");
        } else {
                double promedio = (nota1 + nota2 + nota3) / 3;
            System.out.printf("El promedio de notas del estudiante %s %s es: %.2f%n", 
                            nombreEstudiante, apellidoEstudiante, promedio);
                        }                             
        } 

        public static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 100;
    }

    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
    
}




