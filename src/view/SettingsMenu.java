package view;

import controler.InputControler;
import model.GameSettings;

import java.util.Scanner;

public class SettingsMenu {

    private final Scanner scanner;

    public SettingsMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public GameSettings showSettingsMenu() {
        System.out.println("\n--- НАСТРОЙКИ ИГРЫ ---");

        int language = chooseLanguage();

        if (language == -1) {
            return null;
        }

        int wordLength = chooseWordLength();

        if (wordLength == -1) {
            return null;
        }

        return new GameSettings(language, wordLength);
    }

    private int chooseLanguage() {

        while (true) {
            System.out.println("\nВыберите словарь:");
            System.out.println("1. Русский");
            System.out.println("2. Английский");
            System.out.println("0. Назад");
            System.out.print("Ваш выбор: ");

            String input = scanner.nextLine().trim();

            if (InputControler.isNumberInRange(input, 0, 2)) {

                int language = Integer.parseInt(input);
                if (language == 0) {
                    return -1;
                }
                return language;
            }
            System.out.println("Ошибка! Введите 0, 1 или 2.");
        }
    }

    private int chooseWordLength() {

        while (true) {
            System.out.print(
                    "\nВведите длину слова от 1 до 15 (0 - назад): "
            );
            String input = scanner.nextLine().trim();
            if (input.equals("0")) {
                return -1;
            }
            if (InputControler.isNumberInRange(input, 1, 15)) {
                return Integer.parseInt(input);
            }
            System.out.println(
                    "Ошибка! Введите целое число от 1 до 15."
            );
        }
    }
}