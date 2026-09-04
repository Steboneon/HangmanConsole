package controler;

import java.util.Scanner;

public class LetterInput {

    private final Scanner scanner;

    public LetterInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public char readLetter() {

        while (true) {

            System.out.print("\nВведите букву: ");

            String input = scanner.nextLine().trim();

            if (input.length() == 1) {
                return Character.toUpperCase(
                        input.charAt(0)
                );
            }

            System.out.println(
                    "Ошибка! Введите одну букву."
            );
        }
    }
}