import java.io.*;
import java.nio.file.*;
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("non_existent_file.txt");
        Path filePath = Paths.get("error.log");
        BufferedWriter writer = Files.newBufferedWriter(filePath);
        try { // чтение файла
            if (!file.exists()) { // проверка на существование файла
                throw new CustomFileNotFoundException("Файл не найден: " + file.getName());
            } // если файла нет, то выбрасывается исключение
            FileInputStream fis = new FileInputStream(file); // для чтения из файла
            fis.close(); // закрытие потока чтения файла
        } catch (CustomFileNotFoundException e) { // перехват исключения
            System.out.println(e.getMessage());
            writer.write("Custo: file not found");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
