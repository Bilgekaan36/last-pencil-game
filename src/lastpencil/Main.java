package lastpencil;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] users = new String[] {"John", "Jack"};

        System.out.println("How many pencils would you like to use:");
        int pencils = scanner.nextInt();

        System.out.println("Who will be the first (John, Jack):");
        String inputName = scanner.next();

        for (int i = 0; i < pencils; i++) {
            System.out.print("|");
        }
        System.out.println();
        System.out.printf("%s is going first!", Arrays.stream(users).filter(user -> user.equals(inputName)).findFirst().orElse("User not found!"));
    }
}
