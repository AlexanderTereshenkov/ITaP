import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    private ArrayList<Object> processes = new ArrayList<>();
    private ArrayList<String> data = new ArrayList<>();
    private String destination;

    public DataManager(String destination){
        this.destination = destination;
    }
    public void registerDataProcessor(Object process){
        if(process.getClass().getAnnotation(DataProcessor.class) != null) processes.add(process);
    }

    public void loadData(String source){
        try {
            File file = new File(source);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                data.addAll(Arrays.asList(words));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processData(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(Object process : processes){
            Runnable job = () -> {
                try{
                    for(Method m :process.getClass().getMethods()){
                        if(m.getAnnotation(DataProcessor.class) != null){
                            saveData((ArrayList<String>)m.invoke(process, data));
                        }
                    }
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            };
            executorService.submit(job);
        }
        executorService.shutdown();
    }

    public synchronized void saveData(ArrayList<String> data){
        System.out.println(Arrays.toString(data.toArray()));
        try{
            FileWriter writer = new FileWriter(destination, true);
            for(String str: data) {
                writer.write(str + " ");
            }
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
