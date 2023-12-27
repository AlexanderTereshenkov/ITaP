import java.util.Arrays;

public class Stack <T>{
    private T[] data;
    private int size;
    private static final int CAPACITY = 10;

    public Stack(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    public  Stack(){
        data = (T[])new Object[CAPACITY];
        size = 0;
    }

    public void push(T elem){
        if(data.length < size + 1){
            data = Arrays.copyOf(data, data.length * 2);
        }
        size++;
        data[size-1] = elem;
    }

    public T pop(){
        T elem = data[size-1];
        data[size-1] = null;
        size--;
        return elem;
    }

    public T peek(){
        return data[size-1];
    }

}
