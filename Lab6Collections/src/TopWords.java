import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        try {
            File file = new File("D:\\JavaProjects\\UsingCollections\\SampleText");
            Scanner reader = new Scanner(file);
            String s = "";
            while (reader.hasNext()){
                s = reader.nextLine();
            }
            String[] tempW = s.toLowerCase().split(" ");
            for (String string : tempW) {
                if (wordCount.get(string) == null) {
                    wordCount.put(string, 1);
                } else {
                    wordCount.put(string, wordCount.get(string) + 1);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(int i = 0; i < 10; i++){
            System.out.println(list.get(i));
        }
    }
}
