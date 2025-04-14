/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teatromoroticketsmanager;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author gustavo.dominguez
 */

public class TeatroMoroTicketsManager {

    // Variables estáticas (estadísticas globales)
    static int totalTicketsSold = 0;
    static double totalIncome = 0;
    static int ticketCounter = 1;

    // Variables de instancia para entradas (máximo 4)
    static int ticketNum1 = 0, ticketNum2 = 0, ticketNum3 = 0, ticketNum4 = 0;
    static String location1 = "", location2 = "", location3 = "", location4 = "";
    static String type1 = "", type2 = "", type3 = "", type4 = "";
    static double price1 = 0, price2 = 0, price3 = 0, price4 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String theaterName = "Teatro Moro";
        int theaterCapacity = 100;
        double basePrice = 10000;

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n===== " + theaterName + " - Sistema de Entradas =====");
            System.out.println("1. Venta de entrada");
            System.out.println("2. Ver promociones");
            System.out.println("3. Buscar entrada");
            System.out.println("4. Eliminar entrada");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int option = 0;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    sellTicket(scanner, basePrice);
                    break;
                case 2:
                    showPromotions();
                    break;
                case 3:
                    searchTicket(scanner);
                    break;
                case 4:
                    deleteTicket(scanner);
                    break;
                case 5:
                    continueProgram = false;
                    System.out.println("Gracias por usar el sistema de entradas del Teatro Moro.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    public static void sellTicket(Scanner scanner, double basePrice) {
        if (totalTicketsSold >= 4) {
            System.out.println("\nNo se pueden vender más de 4 entradas.");
            return;
        }

        System.out.println("\n--- Venta de entrada ---");
        System.out.println("Seleccione ubicación: 1. VIP, 2. Platea, 3. General");

        int locationOption = 0;
        try {
            locationOption = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            scanner.nextLine();
            return;
        }

        String location = (locationOption == 1) ? "VIP" : (locationOption == 2) ? "Platea" : "General";

        System.out.print("Ingrese su edad: ");
        int age = 0;
        try {
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Edad inválida. Intente nuevamente.");
            scanner.nextLine();
            return;
        }

        System.out.print("¿Es usted estudiante? (s/n): ");
        String studentResponse = scanner.next();
        boolean isStudent = studentResponse.equalsIgnoreCase("s");

        double discount = 0;
        String type = "General";

        if (isStudent) {
            discount = basePrice * 0.10;
            type = "Estudiante";
        } else if (age >= 65) {
            discount = basePrice * 0.15;
            type = "Tercera Edad";
        }

        double finalPrice = basePrice - discount;
        int currentTicket = ticketCounter++;

        if (totalTicketsSold == 0) {
            ticketNum1 = currentTicket; location1 = location; type1 = type; price1 = finalPrice;
        } else if (totalTicketsSold == 1) {
            ticketNum2 = currentTicket; location2 = location; type2 = type; price2 = finalPrice;
        } else if (totalTicketsSold == 2) {
            ticketNum3 = currentTicket; location3 = location; type3 = type; price3 = finalPrice;
        } else if (totalTicketsSold == 3) {
            ticketNum4 = currentTicket; location4 = location; type4 = type; price4 = finalPrice;
        }

        totalTicketsSold++;
        totalIncome += finalPrice;

        System.out.println("Entrada vendida exitosamente.");
        System.out.println("Número: " + currentTicket + " | Ubicación: " + location + " | Tipo: " + type + " | Precio final: $" + (int)finalPrice);
    }

    public static void showPromotions() {
        System.out.println("\n--- Promociones Disponibles ---");
        System.out.println("- 10% de descuento para estudiantes");
        System.out.println("- 15% de descuento para personas de tercera edad (65+ años)");
        System.out.println("- Compra 3 entradas y recibe una cuarta gratis (simulada al llegar al máximo de 4)");
    }

    public static void searchTicket(Scanner scanner) {
        System.out.println("\n--- Buscar entrada ---");
        System.out.print("Ingrese el número de la entrada a buscar: ");

        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            scanner.nextLine();
            return;
        }

        boolean found = false;

        if (number == ticketNum1) { showTicket(1); found = true; }
        else if (number == ticketNum2) { showTicket(2); found = true; }
        else if (number == ticketNum3) { showTicket(3); found = true; }
        else if (number == ticketNum4) { showTicket(4); found = true; }

        if (!found) {
            System.out.println("Entrada no encontrada.");
        }
    }

    public static void deleteTicket(Scanner scanner) {
        System.out.println("\n--- Eliminar entrada ---");
        System.out.print("Ingrese el número de la entrada a eliminar: ");

        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intente nuevamente.");
            scanner.nextLine();
            return;
        }

        if (number == ticketNum1) { ticketNum1 = 0; location1 = ""; type1 = ""; totalIncome -= price1; price1 = 0; totalTicketsSold--; }
        else if (number == ticketNum2) { ticketNum2 = 0; location2 = ""; type2 = ""; totalIncome -= price2; price2 = 0; totalTicketsSold--; }
        else if (number == ticketNum3) { ticketNum3 = 0; location3 = ""; type3 = ""; totalIncome -= price3; price3 = 0; totalTicketsSold--; }
        else if (number == ticketNum4) { ticketNum4 = 0; location4 = ""; type4 = ""; totalIncome -= price4; price4 = 0; totalTicketsSold--; }
        else {
            System.out.println("Entrada no encontrada.");
            return;
        }

        System.out.println("Entrada eliminada exitosamente.");
    }

    public static void showTicket(int index) {
        System.out.println("\n--- Detalle de la Entrada ---");
        if (index == 1) System.out.println("Número: " + ticketNum1 + " | Ubicación: " + location1 + " | Tipo: " + type1 + " | Precio: $" + (int)price1);
        if (index == 2) System.out.println("Número: " + ticketNum2 + " | Ubicación: " + location2 + " | Tipo: " + type2 + " | Precio: $" + (int)price2);
        if (index == 3) System.out.println("Número: " + ticketNum3 + " | Ubicación: " + location3 + " | Tipo: " + type3 + " | Precio: $" + (int)price3);
        if (index == 4) System.out.println("Número: " + ticketNum4 + " | Ubicación: " + location4 + " | Tipo: " + type4 + " | Precio: $" + (int)price4);
    }
}
