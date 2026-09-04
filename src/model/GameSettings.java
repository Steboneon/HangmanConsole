package model;

public class GameSettings {

    private final int language;
    private final int wordLength;

    public GameSettings(int language, int wordLength) {
        this.language = language;
        this.wordLength = wordLength;
    }
    public int getLanguage() {
        return language;
    }
    public int getWordLength() {
        return wordLength;
    }
}