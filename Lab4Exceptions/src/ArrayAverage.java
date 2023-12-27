import java.util.ArrayList;

public class ArrayAverage {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("asd");
        arr.add("2");
        arr.add("1");
        int sum = 0;
        try{
            for (int i = 0; i < arr.size() + 1; i++) {
                sum += Integer.parseInt(arr.get(i));
            }
            System.out.println(sum / (float)arr.size());
        }catch (NumberFormatException e){
            System.out.println("Ошибка преобразования числа");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Выход за границы массива");
        }
    }
}
