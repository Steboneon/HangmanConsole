package view;

public final class HangmanAscii {
    private static final String[] PICTURES = {
            """
              _______
              |/    |
              |   \s
              |   \s
              |   \s
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |   \s
              |   \s
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |     |
              |     |
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|
              |     |
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|\\
              |     |
              |   \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|\\
              |    /\s
              |   / \s
            __|________
            """,
            """
              _______
              |/    |
              |    ( )
              |    /|\\
              |    / \\
              |   /   \\
            __|________
            """
    };

    private HangmanAscii() {}

    public static String getPicture(int errors) {
        return PICTURES[errors];
    }
}