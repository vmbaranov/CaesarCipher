import java.io.IOException;
import java.util.Scanner;

public class Cipher {
    public Cipher(char[] alphabet) {
    }

    public static String encrypt(String text) {
        System.out.println("Введите ключ шифрования:");
        Scanner console = new Scanner(System.in);
        int key;
        if (console.hasNextInt())
            key = console.nextInt();
        else {
            System.out.println("Ключ должен быть числом!");
            return null;
        }

        String cipheredText = "";
        cipheredText = encrypter(text, key);
        return cipheredText;
    }

    public static String decrypt(String text) {
        System.out.println("Введите ключ шифрования:");
        Scanner console = new Scanner(System.in);
        int key = console.nextInt();

        String encipheredText = "";
        encipheredText = decrypter(text, key);
        return encipheredText;
    }

    public static String encrypter(String text, int key) {
        StringBuilder cipheredText = new StringBuilder();
        int k = key % Alphabet.ALPHABET.size();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isUpperCase(symbol))
                symbol = Character.toLowerCase(symbol);
            if (Alphabet.ALPHABET.contains(symbol)) {
                int index = Alphabet.ALPHABET.indexOf(symbol);
                index += key;
                if (index < 0)
                    index += Alphabet.ALPHABET.size();
                else if (index >= Alphabet.ALPHABET.size())
                    index -= Alphabet.ALPHABET.size();
                symbol = (char) Alphabet.ALPHABET.get(index);
                cipheredText.append(symbol);
            }
        }

        return cipheredText.toString();
    }

    public static String decrypter(String text, int key) {
        StringBuilder encipheredText = new StringBuilder();
        int k = key % Alphabet.ALPHABET.size();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isUpperCase(symbol))
                symbol = Character.toLowerCase(symbol);
            if (Alphabet.ALPHABET.contains(symbol)) {
                int index = Alphabet.ALPHABET.indexOf(symbol);
                index -= key;
                if (index < 0)
                    index += Alphabet.ALPHABET.size();
                else if (index >= Alphabet.ALPHABET.size())
                    index -= Alphabet.ALPHABET.size();
                symbol = (char) Alphabet.ALPHABET.get(index);
                encipheredText.append(symbol);
            }
        }

        return encipheredText.toString();
    }
}
