import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReadFile {
    public static void main(String[] args) {
        try{
            FileReader reader = new FileReader("First.txt");
            FileWriter writer = new FileWriter("Second234.txt");
            while(reader.ready()){
                writer.write(reader.read());
            }
            writer.close();
            reader.close();
        }catch (IOException e){
            System.out.println("Ошибка при открытии/записи файлa");
        }
    }
}
