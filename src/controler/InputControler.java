package controler;

public class InputControler {
    public static boolean isNumberInRange(String input, int min, int max) {
        try {
            int number = Integer.parseInt(input);

            return number >= min && number <= max;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
