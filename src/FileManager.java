import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    public static String readFile() throws IOException {
        System.out.println("Введите путь к файлу");
        Scanner console = new Scanner(System.in);
        String location = console.nextLine();
        Path path = Paths.get(location);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }
    public static void writeFile(String content, String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("Файл создан \nДанные внесены");
            } else {
                System.out.println("Файл уже существует \nДанные обновлены");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}
