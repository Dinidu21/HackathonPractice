package FlightProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Flight> flights = new ArrayList<>();

    public static void addFlights() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Add Flights                                ");
        System.out.println("\t=======================================================================");
        System.out.print("\n\tEnter FlightProject.Flight Number: ");
        String flightnumber = sc.next();
        System.out.print("\n\tEnter Destination: ");
        String destination = sc.next();
        System.out.print("\n\tEnter Departure Time: ");
        String departureTime = sc.next();
        System.out.print("\n\tEnter Available Seats: ");
        int availableSeats = sc.nextInt();
        System.out.print("\n\tEnter Ticket Price: ");
        double ticketPrice = sc.nextDouble();

        Flight f = new Flight(flightnumber, destination, departureTime, availableSeats, ticketPrice);
        flights.add(f);

        System.out.println("\n\tFlightProject.Flight added successfully");
        System.out.print("\n\tDo you want to add new FlightProject.Flight (yes/no) : ");
        String choice = sc.next();
        if (choice.equals("yes")) {
            clearConsole();
            addFlights();
        } else if (choice.equals("no")) {
            System.out.print("\n\tDo you want to Back to Manage Flights Page (yes/no) : ");
            String op = sc.next();
            if (op.equals("yes")) {
                clearConsole();
                manageFlights();
            } else if (op.equals("no")) {
                clearConsole();
                welcome();
            } else {
                System.out.println("Invalid choice");
            }
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
            int count = 0;
            for (Flight f : flights) {
                ++count;
                System.out.println(count + " ) \n \tFlightProject.Flight Number : " + f.getFlightnumber());
                System.out.println(" \tDestination : " + f.getDestination());
                System.out.println(" \tDeparture Time : " + f.getDepartureTime());
                System.out.println(" \tAvailable Seats : " + f.getAvailableSeats());
                System.out.println(" \tTicket Price : " + f.getTicketPrice());
                System.out.println();
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
            System.out.println("\n\tHere are our all Flights Available Currently : ");
            int count = 0;
            for (Flight f : flights) {
                ++count;
                System.out.println(count + " ) \n \tFlightProject.Flight Number : " + f.getFlightnumber());
                System.out.println(" \tDestination : " + f.getDestination());
                System.out.println(" \tDeparture Time : " + f.getDepartureTime());
                System.out.println(" \tAvailable Seats : " + f.getAvailableSeats());
                System.out.println(" \tTicket Price : " + f.getTicketPrice());
            }

            boolean flag = true;
            while (flag) {
                System.out.print("\n\tEnter FlightProject.Flight Number you want to update : ");
                String flightnumber = sc.next();

                if (flights.stream().noneMatch(f -> f.getFlightnumber().equals(flightnumber))) {
                    System.out.println("\n\tFlightProject.Flight not found with this FlightProject.Flight Number. Please try again.");
                } else {
                    flag = false;
                    System.out.print("\n\tEnter New FlightProject.Flight Number you want to update : ");
                    String newFlightnumber = sc.next();
                    System.out.print("\n\tEnter new Destination you want to update: ");
                    String newDestination = sc.next();
                    System.out.print("\n\tEnter new Departure Time you want to update: ");
                    String newDepartureTime = sc.next();
                    System.out.print("\n\tEnter new Available Seats you want to update: ");
                    int newAvailableSeats = sc.nextInt();
                    System.out.print("\n\tEnter new Ticket Price you want to update: ");
                    double newTicketPrice = sc.nextDouble();

                    for (Flight f : flights) {
                        if (f.getFlightnumber().equals(flightnumber)) {
                            f.setFlightnumber(newFlightnumber);
                            f.setDestination(newDestination);
                            f.setDepartureTime(newDepartureTime);
                            f.setAvailableSeats(newAvailableSeats);
                            f.setTicketPrice(newTicketPrice);
                        }
                    }

                    System.out.println("\n\tFlightProject.Flight updated successfully");
                    System.out.print("\n\tDo you want update another FlightProject.Flight (yes/no) : ");
                    String choice = sc.next();
                    if (choice.equals("yes")) {
                        clearConsole();
                        updateFlights();
                    } else if (choice.equals("no")) {
                        System.out.print("\n\tDo you want to Back to Manage Flights Page (yes/no) : ");
                        String op = sc.next();
                        if (op.equals("yes")) {
                            clearConsole();
                            manageFlights();
                        } else if (op.equals("no")) {
                            clearConsole();
                            welcome();
                        } else {
                            System.out.println("Invalid choice");
                        }
                    } else {
                        System.out.println("Invalid choice");
                    }
                }
            }
        }
    }

    public static void deleteFlights() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Delete Flights                                ");
        System.out.println("\t=======================================================================");
        if (flights.isEmpty()) {
            System.out.println("\n\tNo flights available.");
        } else {
            System.out.println("\n\tHere are our all Flights Available Currently : ");
            int i = 0;
            for (Flight f : flights) {
                ++i;
                System.out.println(i + " ) \n \tFlightProject.Flight Number : " + f.getFlightnumber());
                System.out.println(" \tDestination : " + f.getDestination());
                System.out.println(" \tDeparture Time : " + f.getDepartureTime());
                System.out.println(" \tAvailable Seats : " + f.getAvailableSeats());
                System.out.println(" \tTicket Price : " + f.getTicketPrice());
                System.out.println();
            }
        }

        boolean flag = true;
        while (flag) {
            System.out.print("\n\tEnter FlightProject.Flight Number to Delete : ");
            String flightnumber = sc.next();
            // check if flight exists
            if (flights.stream().noneMatch(f -> f.getFlightnumber().equals(flightnumber))) {
                System.out.println("\n\tFlightProject.Flight not found with this FlightProject.Flight Number. Please try again.");
            } else {
                flag = false;
                // delete flight from list if found
                flights.removeIf(f -> f.getFlightnumber().equals(flightnumber));
                System.out.println("\n\tFlightProject.Flight Deleted Successfully");
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
                clearConsole();
                welcome();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void displayAvailableFlights() {
        System.out.println("\n\tHere are the Flights available Right Now");
        System.out.println("\t-------------------------------------------------------------------------------");
        System.out.println("\t|FlightProject.Flight Number | Destination | Departure Time | Available Seats | Ticket Price|");
        System.out.println("\t-------------------------------------------------------------------------------");
        
        if (flights.isEmpty()) {
            System.out.println("\n\tNo flights available.");
            return;
        }
    
        // Check if all flights have no available seats
        boolean allSeatsBooked = true;
        for (Flight f : flights) {
            if (f.getAvailableSeats() > 0) {
                allSeatsBooked = false;
                break;
            }
        }
    
        if (allSeatsBooked) {
            System.out.println("\n\tNo seats available Right Now. All Seats are booked in All Flights.");
            return;
        }
    
        // Sort flights by ticket price in ascending order
        //insertion sort is not effiecient in this case,Here use Comparator comparingDouble
        flights.sort(Comparator.comparingDouble(Flight::getTicketPrice));
    
        // Display sorted flights with available seats
        int count = 0;
        for (Flight f : flights) {
            if (f.getAvailableSeats() > 0) {
                count++;
                System.out.println(count + ") \t" +
                    f.getFlightnumber() + " \t\t" +
                    f.getDestination() + " \t\t" +
                    f.getDepartureTime() + " \t\t" +
                    f.getAvailableSeats() + " \t\t" +
                    f.getTicketPrice());
                    System.out.println("\t=======================================================================");
            }
        }
        
        System.out.println("\t----------------------------------------------------------------------------");
    }
    
    public static void searchFlights(){
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Search Flights                                ");
        System.out.println("\t=======================================================================");
        System.out.println("\n \t[1] Book Tickets");
        System.out.println("\n \t[2] Exit");
        System.out.println("\t=======================================================================");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                displayAvailableFlights();
                break;
            case 2:
                clearConsole();
                welcome();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void bookTickets() {
        System.out.println("\t=======================================================================");
        System.out.println("\t                         Book Tickets                                  ");
        System.out.println("\t=======================================================================");
        System.out.println("\n\t[1]Search Flights");
        System.out.println("\n\t[2] Exit");
        System.out.println("\t=======================================================================");


        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                searchFlights();
                break;
            case 2:
                clearConsole();
                welcome();
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
                clearConsole();
                bookTickets();
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

    private static void clearConsole() {
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
