public class ArrayCounterThread extends Thread{
    private int sum = 0;
    private int[] array;

    public ArrayCounterThread(int[] array){
        this.array = array;
    }

    @Override
    public void run() {
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
    }

    public int GetSum(){
        return sum;
    }

}
