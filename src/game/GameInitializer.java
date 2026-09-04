package game;

import model.GameSettings;
import readInfo.ReadWord;

public class GameInitializer {

    public String initializeGame(GameSettings settings) {

        String dictionary;

        if (settings.getLanguage() == 1) {
            dictionary = "src/resources/russianDictionary.txt";
        } else {
            dictionary = "src/resources/englishDictionary.txt";
        }

        ReadWord readWord = new ReadWord(
                settings.getWordLength()
        );

        readWord.readWord(dictionary);

        return readWord.getWord();
    }
}