package game;

import controler.LetterInput;
import controler.LetterValidator;
import model.GameSettings;
import view.GameView;

import java.util.List;

public class GameProcess {

    private final GameLogics gameLogics;
    private final GameView gameView;
    private final LetterInput letterInput;
    private final LetterValidator letterValidator;

    public GameProcess(
            GameLogics gameLogics,
            GameView gameView,
            LetterInput letterInput
    ) {
        this.gameLogics = gameLogics;
        this.gameView = gameView;
        this.letterInput = letterInput;
        this.letterValidator = new LetterValidator();
    }

    public void start(GameSettings settings) {
        gameLogics.startGame(settings);

        String word = gameLogics.getCurrentWord();

        if (word == null) {
            System.out.println("Не удалось загрузить слово для игры.");
            return;
        }

        GameState gameState = new GameState(word);

        play(gameState, settings.getLanguage());
    }

    private void play(GameState gameState, int languageCode) {
        while (gameState.getErrors() < 6) {

            gameView.showGame(
                    gameState.getHiddenWord(),
                    gameState.getErrors()
            );

            if (isWordGuessed(gameState.getHiddenWord())) {
                System.out.println("\nПоздравляем! Вы выиграли! Загаданное слово: " + gameState.getWord());
                return;
            }

            char letter = letterInput.readLetter();

            if (letterValidator.isLetterValidForLanguage(letter, languageCode)) {

                List<Integer> indices = gameLogics.checkLetter(letter);

                if (indices.isEmpty()) {
                    gameState.addError();
                } else {
                    gameState.openLetters(letter, indices);
                }
            }
        }

        gameView.showGame(gameState.getHiddenWord(), gameState.getErrors());
        System.out.println("\nВы проиграли! Загаданное слово было: " + gameState.getWord());
    }

    private boolean isWordGuessed(char[] hiddenWord) {
        for (char c : hiddenWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

}