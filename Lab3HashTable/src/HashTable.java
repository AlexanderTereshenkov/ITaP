import java.util.Arrays;
import java.util.LinkedList;

public class HashTable<K, V> {

    private class Entry {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int INITIAL_SIZE = 8;

    private LinkedList<Entry>[] table;

    private int size = 0;

    public HashTable() {
        table = new LinkedList[INITIAL_SIZE];
    }

    public HashTable(int size) {
        table = new LinkedList[size];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % table.length;
        if (table[index] == null) {
            Entry entry = new Entry(key, value);
            LinkedList<Entry> elem = new LinkedList<>();
            elem.add(entry);
            table[index] = elem;
            size++;
        } else {
            LinkedList<Entry> elements = table[index];
            for (Entry element : elements) {
                if (element.getKey().equals(key)) {
                    element.setValue(value);
                    return;
                }
            }
            table[index].add(new Entry(key, value));
            size++;
        }
        checkSize();
    }

    private void checkSize(){
        if(size == table.length){
            table = Arrays.copyOf(table, (int)(table.length * 2f));
        }
    }

    public V get(K key){
        int index = Math.abs(key.hashCode()) % table.length;
        LinkedList<Entry> elements = table[index];
        if(elements != null){
            for (Entry element : elements) {
                if (element.getKey().equals(key)) return element.getValue();
            }
        }
        return null;
    }

    public void remove(K key){
        int index = Math.abs(key.hashCode()) % table.length;
        LinkedList<Entry> elements = table[index];
        if(elements != null){
            for(int i = 0; i < elements.size(); i++){
                if(elements.get(i).getKey().equals(key)) elements.remove(elements.get(i));
                size--;
                return;
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}