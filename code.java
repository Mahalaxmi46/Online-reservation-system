package Basic_practice;

import java.util.Scanner;

public class online_reservation_system 
{

    private static boolean[] seats = new boolean[10]; // initialize an array of 10 seats, all empty

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // display menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seats");
            System.out.println("3. Cancel Reservations");
            System.out.println("4. Exit");

            // get user input
            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    viewSeatMap();
                    break;

                case 2:
                    reserveSeats();
                    break;

                case 3:
                    cancelReservations();
                    break;

                case 4:
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void viewSeatMap() 
    {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) 
        {
            if (seats[i]) 
            {
                System.out.print("X "); // print an "X" if the seat is reserved
            } 
            else 
            {
                System.out.print((i + 1) + " "); // print the seat number if it's empty
            }
        }
        System.out.println();
    }

    private static void reserveSeats() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of seats to reserve: ");
        int numSeats = scanner.nextInt();

        System.out.print("Enter seat numbers (1-10) separated by spaces: ");
        for (int i = 0; i < numSeats; i++) 
        {
            int seatNumber = scanner.nextInt();
            reserveSeat(seatNumber);
        }
    }

    private static void reserveSeat(int seatNumber) 
    {
        if (seatNumber < 1 || seatNumber > 10) 
        {
            System.out.println("Invalid seat number!");
        } 
        else if (seats[seatNumber - 1]) 
        {
            System.out.println("Seat " + seatNumber + " already reserved!");
        } 
        else 
        {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat " + seatNumber + " reserved!");
        }
    }

    private static void cancelReservations() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of reservations to cancel: ");
        int numReservations = scanner.nextInt();

        System.out.print("Enter seat numbers (1-10) separated by spaces: ");
        for (int i = 0; i < numReservations; i++) 
        {
            int seatNumber = scanner.nextInt();
            cancelReservation(seatNumber);
        }
    }

    private static void cancelReservation(int seatNumber) 
    {
        if (seatNumber < 1 || seatNumber > 10) 
        {
            System.out.println("Invalid seat number!");
        } 
        else if (!seats[seatNumber - 1]) 
        {
            System.out.println("Seat " + seatNumber + " not reserved!");
        } 
        else 
        {
            seats[seatNumber - 1] = false; // unreserve the seat
            System.out.println("Reservation for seat " + seatNumber + " canceled!");
        }
    }
}
