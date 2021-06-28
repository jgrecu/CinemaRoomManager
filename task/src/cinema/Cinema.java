package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    public static final int MAX_NUMBER_SEATS = 60;
    public static final int NORMAL_TICKET_PRICE = 10;
    public static final int REDUCED_TICKET_PRICE = 8;
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of rows: ");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seatsPerRow = scanner.nextInt();

        String[][] cinemaRoom = createCinemaRoom(numberOfRows, seatsPerRow);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            //scanner.nextLine();
            if (choice == 1) {
                printCinemaRoom(cinemaRoom);
            } else if (choice == 2) {
                cinemaRoom = buyTicket(cinemaRoom);
            } else if (choice == 0) {
                scanner.close();
                break;
            }
        }

//        int totalIncome = 0;
//        if (totalNumberOfSeats <= 60) {
//            totalIncome = totalNumberOfSeats * 10;
//        } else {
//            totalIncome = (numberOfRows / 2 * seatsPerRow * 10) + ((numberOfRows - numberOfRows / 2) * seatsPerRow * 8);
//        }
//
//        System.out.println("Total income:");
//        System.out.println("$" + totalIncome);
    }

    public static String[][] createCinemaRoom(int rows, int seatsPerRow) {
        final String[][] cinemaRoom = new String[rows][seatsPerRow];
        for (String[] strings : cinemaRoom) {
            Arrays.fill(strings, "S");
        }
        return cinemaRoom;
    }

    public static String[][] buyTicket(String[][] cinema) {
        final String[][] cinemaRoom = cinema.clone();
        System.out.println();
        System.out.println("Enter a row number: ");
        int choiceRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int choiceSeat = scanner.nextInt();
        scanner.nextLine();

        int totalNumberOfSeats = cinemaRoom.length * cinemaRoom[0].length;

        cinemaRoom[choiceRow - 1][choiceSeat - 1] = "B";

        int ticketPrice;
        if (totalNumberOfSeats <= MAX_NUMBER_SEATS || choiceRow <= cinemaRoom.length / 2) {
            ticketPrice = NORMAL_TICKET_PRICE;
        } else {
            ticketPrice = REDUCED_TICKET_PRICE;
        }

        System.out.println("Ticket price: $" + ticketPrice);
        return cinemaRoom;
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }

    public static void printCinemaRoom(String[][] cinemaRoom) {
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i <= cinemaRoom[0].length; i++) {
            System.out.print(i == 0 ? " " : " " + i);
        }
        System.out.println();
        for (int i = 0; i < cinemaRoom.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(cinemaRoom[i][j] + " ");
            }
            System.out.println();
        }
    }
}