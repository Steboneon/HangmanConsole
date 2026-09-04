package game;

import model.GameSettings;

import java.util.List;

public class GameLogics {

    private final GameInitializer gameInitializer;
    private final LetterChecker letterChecker;
    private String currentWord; // Хранит загаданное слово текущей игры

    public GameLogics() {
        this.gameInitializer = new GameInitializer();
        this.letterChecker = new LetterChecker();
    }

    public void startGame(GameSettings settings) {
        this.currentWord = gameInitializer.initializeGame(settings);
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public List<Integer> checkLetter(char letter) {
        if (currentWord == null) {
            return List.of();
        }
        return letterChecker.findCharacterIndices(currentWord, letter);
    }
}