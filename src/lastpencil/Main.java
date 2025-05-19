package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();

        final String HUMAN = "John";
        final String BOT   = "Jack";

        // 1) Anzahl der Stifte einlesen und validieren
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

        // 2) Wer fängt an? (HUMAN oder BOT)
        System.out.println("Who will be the first (John, Jack):");
        String currentPlayer;
        while (true) {
            currentPlayer = scanner.nextLine();
            if (currentPlayer.equals(HUMAN) || currentPlayer.equals(BOT)) {
                break;
            }
            System.out.println("Choose between 'John' and 'Jack'");
        }

        // 3) Spielschleife
        while (pencils > 0) {
            // 3.1 Stifte anzeigen
            for (int i = 0; i < pencils; i++) {
                System.out.print("|");
            }
            System.out.println();

            // 3.2 Zug-Ankündigung
            System.out.println(currentPlayer + "'s turn!");

            int taken;
            if (currentPlayer.equals(BOT)) {
                // Bot zieht
                if (pencils % 4 == 1) {
                    // losing position: zufällig 1..min(3,pencils)
                    int maxTake = Math.min(3, pencils);
                    taken = rng.nextInt(maxTake) + 1;
                } else {
                    // winning position: Rest %4 → 1
                    int mod = pencils % 4;
                    taken = (mod == 0) ? 3 : mod - 1;
                }
                System.out.println(taken);
            } else {
                // Mensch zieht
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
            }

            // 3.3 Stifte abziehen
            pencils -= taken;

            // 3.4 Prüfen auf Spielende
            if (pencils == 0) {
                // Wer den letzten Stift nimmt, verliert → anderer gewinnt
                String winner = currentPlayer.equals(HUMAN) ? BOT : HUMAN;
                System.out.println(winner + " won!");
                break;
            }

            // 3.5 Spieler wechseln
            currentPlayer = currentPlayer.equals(HUMAN) ? BOT : HUMAN;
        }

        scanner.close();
    }
}
