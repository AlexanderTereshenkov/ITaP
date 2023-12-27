import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,113,9}, {10,11,90}};
        MaxElementInMatrixThread thread1 = new MaxElementInMatrixThread(Arrays.copyOfRange(matrix, 0,
                matrix.length / 2));
        MaxElementInMatrixThread thread2 = new MaxElementInMatrixThread(Arrays.copyOfRange(matrix, matrix.length / 2,
                matrix.length));

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println(Math.max(thread1.GetMaxElem(), thread2.GetMaxElem()));
    }
}
