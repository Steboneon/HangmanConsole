package game;

import java.util.ArrayList;
import java.util.List;

public class LetterChecker {

    public List<Integer> findCharacterIndices(String word, char letter) {
        List<Integer> indices = new ArrayList<>();

        char lowerLetter = Character.toLowerCase(letter);
        String lowerWord = word.toLowerCase();

        for (int i = 0; i < lowerWord.length(); i++) {
            if (lowerWord.charAt(i) == lowerLetter) {
                indices.add(i);
            }
        }
        return indices;
    }
}