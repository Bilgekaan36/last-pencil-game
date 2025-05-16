package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] players = {"John", "Jack"};

        System.out.println("How many pencils would you like to use:");
        int pencils = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Who will be the first (John, Jack):");
        String currentPlayer = scanner.nextLine();

        while (pencils > 0) {
            // Print pencils
            for (int i = 0; i < pencils; i++) {
                System.out.print("|");
            }
            System.out.println();

            // Print turn
            System.out.println(currentPlayer + "'s turn:");

            // Get input
            int taken = scanner.nextInt();

            pencils -= taken;

            // Switch player
            currentPlayer = currentPlayer.equals(players[0]) ? players[1] : players[0];
        }
    }
}
