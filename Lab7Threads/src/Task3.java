public class Task3 {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Worker worker1 = new Worker(storage, "1");
        Worker worker2 = new Worker(storage, "2");
        Worker worker3 = new Worker(storage, "3");
        Transfer transfer = new Transfer(storage);

        worker1.start();
        worker2.start();
        worker3.start();
        transfer.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
            transfer.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Work is done!");
    }
}
