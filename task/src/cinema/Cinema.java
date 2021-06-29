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

            if (choice == 0) {
                scanner.close();
                break;
            } else if (choice == 1) {
                printCinemaRoom(cinemaRoom);
            } else if (choice == 2) {
                cinemaRoom = buyTicket(cinemaRoom);
            } else if (choice == 3) {
                getStatistics(cinemaRoom);
            }
        }
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

        int choiceRow = -1;
        int choiceSeat = -1;
        boolean isWrongSeat = true;
        while (isWrongSeat) {
            System.out.println();
            System.out.println("Enter a row number: ");
            choiceRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row: ");
            choiceSeat = scanner.nextInt();
            boolean rowNotOutOfBounds = choiceRow - 1 < 0 || choiceRow > cinemaRoom.length;
            boolean seatNotOutOfBounds = choiceSeat -1 < 0 || choiceSeat > cinemaRoom[0].length;
            if (rowNotOutOfBounds || seatNotOutOfBounds) {
                System.out.println("Wrong input!");
                continue;
            } else if (cinemaRoom[choiceRow - 1][choiceSeat - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
                continue;
            } else {
                isWrongSeat = false;
            }
        }

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
        System.out.println("\n1. Show the seats" +
                "\n2. Buy a ticket" +
                "\n3. Statistics" +
                "\n0. Exit");
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

    public static void getStatistics(String[][] cinema) {
        if (cinema != null) {
            int numberOfRows = cinema.length;
            int seatsPerRow = cinema[0].length;
            int totalNumberOfSeats = numberOfRows * seatsPerRow;
            int totalIncome = 0;
            int ticketsPurchased = 0;
            int currentIncome = 0;
            int lowerRows = numberOfRows / 2;
            int upperRows = numberOfRows % 2 == 0 ? numberOfRows + 1 - numberOfRows / 2 : numberOfRows - numberOfRows / 2;
            if (totalNumberOfSeats <= MAX_NUMBER_SEATS) {
                totalIncome = totalNumberOfSeats * NORMAL_TICKET_PRICE;
            } else {
                totalIncome = (numberOfRows / 2 * seatsPerRow * NORMAL_TICKET_PRICE) +
                        ((numberOfRows - numberOfRows / 2) * seatsPerRow * REDUCED_TICKET_PRICE);
            }


            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < seatsPerRow; j++) {
                    if (cinema[i][j].equals("B") && totalNumberOfSeats <= MAX_NUMBER_SEATS ||
                            cinema[i][j].equals("B") && i <= lowerRows - 1) {
                        ticketsPurchased++;
                        currentIncome += NORMAL_TICKET_PRICE;
                    } else if (cinema[i][j].equals("B") && i >= upperRows - 1) {
                        ticketsPurchased++;
                        currentIncome += REDUCED_TICKET_PRICE;
                    }
                }
            }

            double percentage = ticketsPurchased * 100.0 / totalNumberOfSeats;

            System.out.println();
            System.out.println("Number of purchased tickets: " + ticketsPurchased);
            System.out.printf("Percentage: %.2f%c%n", percentage, '%');
            System.out.println("Current income: $" + currentIncome);
            System.out.println("Total income: $" + totalIncome);
        }
    }
}