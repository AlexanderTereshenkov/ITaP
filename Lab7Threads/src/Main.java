import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{10, 11, 3};
        ArrayCounterThread firstThread = new ArrayCounterThread(Arrays.copyOfRange(a, 0, a.length / 2));
        ArrayCounterThread secondThread = new ArrayCounterThread(Arrays.copyOfRange(a, a.length / 2, a.length));
        firstThread.start();
        secondThread.start();
        try{
            firstThread.join();
            secondThread.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(firstThread.GetSum() + secondThread.GetSum());
    }
}