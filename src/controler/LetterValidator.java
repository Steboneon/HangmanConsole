package controler;

public class LetterValidator {

    public boolean isLetterValidForLanguage(char letter, int languageChoice) {
        char lower = Character.toLowerCase(letter);

        boolean isEnglish = (lower >= 'a' && lower <= 'z');
        boolean isRussian = (lower >= 'а' && lower <= 'я') || lower == 'ё';

        if (languageChoice == 2 && isRussian) {
            System.out.println("Ошибка: вы выбрали английский словарь! Пожалуйста, переключите раскладку на английский.");
            return false;
        }

        // Допустим, 1 — это русский словарь
        if (languageChoice == 1 && isEnglish) {
            System.out.println("Ошибка: вы выбрали русский словарь! Пожалуйста, переключите раскладку на русский.");
            return false;
        }

        if (!isEnglish && !isRussian) {
            System.out.println("Пожалуйста, введите корректную букву алфавита.");
            return false;
        }

        return true;
    }
}