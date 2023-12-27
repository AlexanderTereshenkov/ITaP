public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("FFFFF", "wefewfewf", 124214);
        Order order2 = new Order("ewkfjwelf", "wkghjerig", 214214);
        HashTable<Integer, Order> hashTable = new HashTable<>(1);
        hashTable.put(123, order1);
        hashTable.put(2, order2);
        System.out.println(hashTable.size());
        hashTable.remove(2);
        System.out.println(hashTable.get(2));
    }
}