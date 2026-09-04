package view;

public class GameView {

    public void showGame(
            char[] hiddenWord,
            int errors
    ) {

        System.out.println();
        System.out.println(
                HangmanAscii.getPicture(errors)
        );

        System.out.print("Слово: ");

        for (char letter : hiddenWord) {
            System.out.print(letter + " ");
        }

        System.out.println();
    }
}