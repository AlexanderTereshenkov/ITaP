public class Transfer extends Thread{
    private boolean isStorgeWorking = true;
    private Storage storage;
    public Transfer(Storage storage){
        this.storage = storage;
    }
    @Override
    public void run() {
        while(isStorgeWorking){
            storage.move(this);
        }
    }

    public void StopWorking(){
        System.out.println("stop transfer");
        isStorgeWorking = false;
    }
}
