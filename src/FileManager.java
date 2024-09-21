import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    public static String readFile() throws IOException {
        System.out.println("С каким файлом работаем? Укажите полный путь к файлу:");
        Scanner console = new Scanner(System.in);
        String location = console.nextLine();
        Path path = Paths.get(location);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }
    public static void writeFile(String content) {
        System.out.println("В какой папке создать файл? Укажите путь к папке:");
        Scanner console = new Scanner(System.in);
        String location = console.nextLine();
        System.out.println("Как назовем файл? Введите название:");
        String fileName = console.nextLine() + ".txt";
        Path dir = Paths.get(location);
        if (Files.exists(dir.resolve(fileName))) {
            System.out.println("Файл уже существует \nДанные обновлены");
        }
        else {
            try {
                Files.createFile(dir.resolve(fileName));
                System.out.println("Файл создан \nДанные внесены");
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла");
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(location + "/" + fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}
