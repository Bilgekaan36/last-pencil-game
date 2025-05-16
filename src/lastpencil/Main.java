package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] players = {"John", "Jack"};

        // 1. Anzahl der Stifte einlesen und validieren
        System.out.println("How many pencils would you like to use:");
        int pencils;
        while (true) {
            String line = scanner.nextLine();
            if (!line.matches("\\d+")) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            pencils = Integer.parseInt(line);
            if (pencils == 0) {
                System.out.println("The number of pencils should be positive");
            } else {
                break;
            }
        }

        // 2. Startspieler auswählen und validieren
        System.out.println("Who will be the first (John, Jack):");
        String currentPlayer;
        while (true) {
            currentPlayer = scanner.nextLine();
            if (currentPlayer.equals("John") || currentPlayer.equals("Jack")) {
                break;
            }
            System.out.println("Choose between 'John' and 'Jack'");
        }

        // 3. Spielschleife
        while (pencils > 0) {
            // 3.1 Anzeige der verbleibenden Stifte
            for (int i = 0; i < pencils; i++) {
                System.out.print("|");
            }
            System.out.println();

            // 3.2 Hinweis auf den Zug
            System.out.println(currentPlayer + "'s turn!");

            // 3.3 Einlesen und Validieren des Zuges
            int taken;
            while (true) {
                String move = scanner.nextLine();
                if (!move.matches("\\d+")) {
                    System.out.println("Possible values: '1', '2' or '3'");
                    continue;
                }
                taken = Integer.parseInt(move);
                if (taken < 1 || taken > 3) {
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if (taken > pencils) {
                    System.out.println("Too many pencils were taken");
                } else {
                    break;
                }
            }

            // 3.4 Stifte abziehen
            pencils -= taken;

            // 3.5 Prüfen, ob das Spiel endet
            if (pencils == 0) {
                // Wer gerade gezogen hat, verliert → der andere gewinnt
                String winner = currentPlayer.equals(players[0]) ? players[1] : players[0];
                System.out.println(winner + " won!");
                break;
            }

            // 3.6 Spielerwechsel
            currentPlayer = currentPlayer.equals(players[0]) ? players[1] : players[0];
        }

        scanner.close();
    }
}
