package game;

import java.util.Arrays;
import java.util.List;

public class GameState {

    private final String word;
    private final char[] hiddenWord;

    private int errors;

    public GameState(String word) {
        this.word = word;
        this.hiddenWord = new char[word.length()];

        Arrays.fill(hiddenWord, '_');

        errors = 0;
    }

    public String getWord() {
        return word;
    }

    public char[] getHiddenWord() {
        return hiddenWord;
    }

    public int getErrors() {
        return errors;
    }

    public void addError() {
        errors++;
    }

    public void openLetters(char letter, List<Integer> indices) {
        char targetChar = Character.toLowerCase(letter);
        for (int index : indices) {
            hiddenWord[index] = Character.toLowerCase(word.charAt(index));
        }
    }
}