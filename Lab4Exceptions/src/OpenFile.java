import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class OpenFile {
    public static void main(String[] args) {
        try{
            openFile("Third.txt");
        }catch (CustomFileNotFoundException e){
            try{
                FileWriter writer = new FileWriter("ExceptionLogs.txt", true);
                writer.write(e.getMessage() + " " + LocalDateTime.now() + "\n");
                writer.close();
            }catch (IOException exception){
                System.out.println("Ошибка при логировании");
            }
            System.out.println(e.getMessage());
        }
    }

    private static void openFile(String fileName) throws CustomFileNotFoundException{
        File file = new File(fileName);
        if(!file.exists()){
            throw new CustomFileNotFoundException("Файл с таким именем не найден");
        }
        else {
            try{
                FileReader fileReader = new FileReader(fileName);
            } catch (IOException e){
                System.out.println("Не удалось открыть файл");
            }
        }
    }
}

