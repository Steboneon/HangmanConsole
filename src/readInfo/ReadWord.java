package readInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadWord {
    private String newWord;
    private int wordLength;

    public ReadWord() {}
    public ReadWord(int wordLength) {
        this.wordLength = wordLength;
    }

    public List<Integer> findValidIndices(String fileName) {
        List<Integer> validIndices = new ArrayList<>();
        int currentIndex = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.trim().length() == wordLength) {
                    validIndices.add(currentIndex);
                }
                currentIndex++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return validIndices;
    }

    public String fetchWordAtLine(String fileName, int targetLine) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            int lineCounter = 0;
            while ((currentLine = reader.readLine()) != null) {
                if (lineCounter == targetLine) {
                    return currentLine.trim();
                }
                lineCounter++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении слова: " + e.getMessage());
        }
        return null;
    }

    public void readWord(String fileName) {
        List<Integer> validIndices = findValidIndices(fileName);

        if (validIndices.isEmpty()) {
            System.out.println("В файле нет слов длиной " + wordLength + " букв!");
            return;
        }

        int targetLine = validIndices.get(new Random().nextInt(validIndices.size()));
        this.newWord = fetchWordAtLine(fileName, targetLine);

        if (this.newWord != null) {
            this.wordLength = this.newWord.length();
        }
    }
    public String getWord() {
        return newWord;
    }

    public int getWordLength() {
        return wordLength;
    }
}