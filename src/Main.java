import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("ШИФР ЦЕЗАРЯ");
        System.out.println(" ");
        System.out.println("МЕНЮ");
        System.out.println("1. Шифрование");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Расшифровка без ключа");
        System.out.println("4. Выйти");

        Scanner console = new Scanner(System.in);
        int j = console.nextInt();
        String text = "";
        String result = "";

        switch (j) {
            case 1:
                text = FileManager.readFile();
                result = Cipher.encrypt(text);
                FileManager.writeFile(result,"CipherOutput.txt");
                break;
            case 2:
                text = FileManager.readFile();
                result = Cipher.decrypt(text);
                FileManager.writeFile(result,"EncipherOutput.txt");
                break;
            case 3:
                text = FileManager.readFile();
                result = BruteForce.bruteForce(text);
                FileManager.writeFile(result,"BruteForceOutput.txt");
                break;
            case 4:
                System.out.println("ВЫХОД");
                break;
            default:
                System.out.println("ОШИБКА, ЗАВЕРШЕНИЕ РАБОТЫ");
        }

    }
}
