public class Worker extends Thread{
    private boolean isStorgeWorking = true;
    private Storage storage;
    private String name;
    public Worker(Storage storage, String name){
        this.storage = storage;
        this.name = name;
    }

    @Override
    public void run() {
        while(isStorgeWorking){
            storage.take(this);
        }
    }

    public void StopWorking(){
        System.out.println("Stop worker "+ name);
        isStorgeWorking = false;
    }
}
