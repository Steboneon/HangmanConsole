package view;

import controler.LetterInput; // проверьте пакет (controller или controler)
import game.GameLogics;
import game.GameProcess;
import model.GameSettings;

import java.util.Scanner;

public class StartMenu {

    private final GameView gameView;
    private final Scanner scanner;
    private final SettingsMenu settingsMenu;
    private final GameLogics gameLogics;
    private final GameProcess gameProcess; // Добавили поле

    public StartMenu() {
        scanner = new Scanner(System.in);
        settingsMenu = new SettingsMenu(scanner);
        gameLogics = new GameLogics();
        gameView = new GameView();

        LetterInput letterInput = new LetterInput(scanner);

        this.gameProcess = new GameProcess(gameLogics, gameView, letterInput);
    }

    public void startApp() {

        while (true) {

            System.out.println("\n=== ВИСЕЛИЦА ===");
            System.out.println("1. Играть");
            System.out.println("2. Выйти");
            System.out.print("Выберите пункт меню: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {

                GameSettings settings = settingsMenu.showSettingsMenu();

                if (settings != null) {
                    gameProcess.start(settings);
                }

            } else if (choice.equals("2")) {

                System.out.println("Спасибо за игру! До свидания.");
                return;

            } else {
                System.out.println("Ошибка! Введите 1 или 2.");
            }
        }
    }
}