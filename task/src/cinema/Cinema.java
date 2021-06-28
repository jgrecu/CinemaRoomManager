package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
//        System.out.println("Cinema:");
//        System.out.println("  1 2 3 4 5 6 7 8");
//        for (int i = 0; i < 7; i++) {
//            System.out.print((i + 1) + " ");
//            for (int j = 0; j < 8; j++) {
//                System.out.print("S ");
//            }
//            System.out.println();
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seatsPerRow = scanner.nextInt();
        scanner.close();

        int totalIncome = 0;
        int totalNumberOfSeats = numberOfRows * seatsPerRow;
        if (totalNumberOfSeats <= 60) {
            totalIncome = totalNumberOfSeats * 10;
        } else {
            totalIncome = (numberOfRows / 2 * seatsPerRow * 10) + ((numberOfRows - numberOfRows / 2) * seatsPerRow * 8);
        }

        System.out.println("Total income:");
        System.out.println("$" + totalIncome);
    }
}