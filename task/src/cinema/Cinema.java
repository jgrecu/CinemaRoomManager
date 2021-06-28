package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seatsPerRow = scanner.nextInt();


        int totalNumberOfSeats = numberOfRows * seatsPerRow;

        String[][] cinemaRoom = new String[numberOfRows][seatsPerRow];

        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                cinemaRoom[i][j] = "S";
            }
        }

        printCinemaRoom(cinemaRoom);

        System.out.println();
        System.out.println("Enter a row number: ");
        int choiceRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int choiceSeat = scanner.nextInt();
        scanner.close();

        cinemaRoom[choiceRow - 1][choiceSeat - 1] = "B";

        int ticketPrice = 0;
        if (totalNumberOfSeats <= 60) {
            ticketPrice = 10;
        } else if (choiceRow <= numberOfRows / 2) {
            ticketPrice = 10;
        } else {
            ticketPrice = 8;
        }

        System.out.println("\nTicket price: $" + ticketPrice + "\n");

        printCinemaRoom(cinemaRoom);

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

    private static void printCinemaRoom(String[][] cinemaRoom) {
        System.out.println("Cinema:");
        for (int i = 0; i <= cinemaRoom[0].length; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else if (i < cinemaRoom[0].length) {
                System.out.print(i + " ");
            } else {
                System.out.println(i);
            }
        }
        for (int i = 0; i < cinemaRoom.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(cinemaRoom[i][j] + " ");
            }
            System.out.println();
        }
    }
}