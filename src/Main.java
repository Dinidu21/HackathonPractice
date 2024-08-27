import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Flight> flights = new ArrayList<>();

    public static void addFlights() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Add Flights                                ");
        System.out.println("\t=======================================================================");
        System.out.print("\n\tEnter Flight Number: ");
        String flightnumber = sc.next();
        System.out.print("\n\tEnter Destination: ");
        String destination = sc.next();
        System.out.print("\n\tEnter Departure Time: ");
        int departureTime = sc.nextInt();
        System.out.print("\n\tEnter Available Seats: ");
        int availableSeats = sc.nextInt();
        System.out.print("\n\tEnter Ticket Price: ");
        double ticketPrice = sc.nextDouble();

        Flight f = new Flight(flightnumber, destination, departureTime, availableSeats, ticketPrice);
        flights.add(f); 

        System.out.println("\n\tFlight added successfully");
        System.out.print("\n\tDo you want to Back to Manage Flights Page (yes/no) : ");

        String choice = sc.next();

        if (choice.equals("yes")) {
            clearConsole();
            manageFlights();
        } else if (choice.equals("no")) {
            clearConsole();
            welcome();
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void viewFlights() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         View Flights                                ");
        System.out.println("\t=======================================================================");
        if (flights.isEmpty()) {
            System.out.println("\n\tNo flights available.");
        } else {
            for (Flight f : flights) {
                System.out.println(" \tFlight Number : " + f.getFlightnumber());
                System.out.println(" \tDestination : " + f.getDestination());
                System.out.println(" \tDeparture Time : " + f.getDepartureTime());
                System.out.println(" \tAvailable Seats : " + f.getAvailableSeats());
                System.out.println(" \tTicket Price : " + f.getTicketPrice());
            }
        }
        System.out.print("\n\tDo you want to Back to Manage Flights Page (yes/no) : ");
        String choice = sc.next();

        if (choice.equals("yes")) {
            clearConsole();
            manageFlights();
        } else if (choice.equals("no")) {
            clearConsole();
            welcome();
        } else {
            System.out.println("Invalid choice");
        }
    }
    public static void updateFlights() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Update Flights                                ");
        System.out.println("\t=======================================================================");
        if (flights.isEmpty()) {
            System.out.println("\n\tNo flights available.");
        } else {
            for (Flight f : flights) {
                System.out.println(" \tFlight Number : " + f.getFlightnumber());
                System.out.println(" \tDestination : " + f.getDestination());
                System.out.println(" \tDeparture Time : " + f.getDepartureTime());
                System.out.println(" \tAvailable Seats : " + f.getAvailableSeats());
                System.out.println(" \tTicket Price : " + f.getTicketPrice());

                System.out.print("\n\tEnter new Flight Number: ");
                String newFlightnumber = sc.next();
                System.out.print("\n\tEnter new Destination: ");
                String newDestination = sc.next();
                System.out.print("\n\tEnter new Departure Time: ");
                int newDepartureTime = sc.nextInt();
                System.out.print("\n\tEnter new Available Seats: ");
                int newAvailableSeats = sc.nextInt();
                System.out.print("\n\tEnter new Ticket Price: ");
                double newTicketPrice = sc.nextDouble();

                f.setFlightnumber(newFlightnumber);
                f.setDestination(newDestination);
                f.setDepartureTime(newDepartureTime);
                f.setAvailableSeats(newAvailableSeats);
                f.setTicketPrice(newTicketPrice);
            }
        }

        System.out.println("\n\tFlight updated successfully");
        System.out.print("\n\tDo you want to Back to Manage Flights Page (yes/no) : ");
        String choice = sc.next();

        if (choice.equals("yes")) {
            clearConsole();
            manageFlights();
        } else if (choice.equals("no")) {
            clearConsole();
            welcome();
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void deleteFlights() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Delete Flights                                ");
        System.out.println("\t=======================================================================");
        if (flights.isEmpty()) {
            System.out.println("\n\tNo flights available.");
        }else {
            System.out.println("\n\tHere are our all Flights Available Currently : ");
            for (Flight f : flights) {
                System.out.println(" \tFlight Number : " + f.getFlightnumber());
                System.out.println(" \tDestination : " + f.getDestination());
                System.out.println(" \tDeparture Time : " + f.getDepartureTime());
                System.out.println(" \tAvailable Seats : " + f.getAvailableSeats());
                System.out.println(" \tTicket Price : " + f.getTicketPrice());
            }
            System.out.print("\n\tEnter Flight Number to Delete : ");   
            String flightnumber = sc.next();
            flights.removeIf(f -> f.getFlightnumber().equals(flightnumber));
            System.out.println("\n\tFlight Deleted Successfully");
        }

        System.out.print("\n\tDo you want to Back to Manage Flights Page (yes/no) : ");
        String choice = sc.next(); 
        if (choice.equals("yes")) {
            clearConsole();
            manageFlights();
        } else if (choice.equals("no")) {
            clearConsole();
            welcome();
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void manageFlights() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Manage Flights                                ");
        System.out.println("\t=======================================================================");
        System.out.println("\n \t[1] Add Flights");
        System.out.println("\n \t[2] View Flights");
        System.out.println("\n \t[3] Update Flights");
        System.out.println("\n \t[4] Delete Flights");
        System.out.println("\n \t[5] Exit");
        System.out.println("\t=======================================================================");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                addFlights();
                break;
            case 2:
                clearConsole();
                viewFlights();
                break;
            case 3:
                clearConsole();
                updateFlights(); 
                break;
            case 4:
                clearConsole();
                deleteFlights();
                break;
            case 5:
                System.out.println("Exiting ");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void welcome() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                    Welcome to Airline Ticket Booking System");
        System.out.println("\t=======================================================================");
        System.out.println("\n \t[1] Manage Flights");
        System.out.println("\n \t[2] Book Tickets");
        System.out.println("\n \t[3] Seating Arrangements");
        System.out.println("\n \t[4] Search and Filter");
        System.out.println("\n \t[5] Cancel and Modify Bookings");
        System.out.println("\n \t[6] Exit");
        System.out.println("\t=======================================================================");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                manageFlights();
                break;
            case 2:
                System.out.println("Book Tickets");
                break;
            case 3:
                System.out.println("Seating Arrangements");
                break;
            case 4:
                System.out.println("Search and Filter");
                break;
            case 5:
                System.out.println("Cancel and Modify Bookings");
                break;
            case 6:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Linux")) {
                System.out.print("\033\143");
            } else if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        welcome();
    }
}
