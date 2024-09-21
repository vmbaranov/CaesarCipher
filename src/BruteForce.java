public class BruteForce {
    public BruteForce(char[] alphabet) {
    }

    public static String bruteForce(String text) {
        String forcedText;
        String correctText = "";

        for (int key = 0; key <= Alphabet.ALPHABET.size() - 1; key++) {
            double spacesCount = 0.0;
            forcedText = Cipher.decrypter(text, key);

            for (int i = 0; i < forcedText.length(); i++) {
                char symbol = forcedText.charAt(i);
                if (Alphabet.ALPHABET.indexOf(symbol) == Alphabet.ALPHABET.indexOf(' '))
                    spacesCount++;
            }

            double spacesProportion = text.length() / spacesCount;

            if (spacesProportion > (Alphabet.averageSpacesCount - 1.0)
            && spacesProportion < (Alphabet.averageSpacesCount + 1.0))
                correctText = forcedText;
        }

        return correctText;
    }
}
