import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
    private int totalWeight = 0;
    private boolean takeWeight = true;
    private ReentrantLock locker;
    private Condition isFull;
    private Condition isMoved;

    private LinkedList<Integer> weights = new LinkedList<>();
    public Storage(){
        locker = new ReentrantLock();
        isFull = locker.newCondition();
        isMoved = locker.newCondition();
        weights.addLast(50);
        weights.addLast(50);
        weights.addLast(50);
        weights.addLast(20);
        weights.addLast(50);
        weights.addLast(23);
        weights.addLast(45);
        weights.addLast(50);
        weights.addLast(50);
        weights.addLast(50);
        //weights.addLast(34);
    }

    public void take(Worker worker){
        locker.lock();
        try{
            while(!takeWeight){
                System.out.println("I blocked workers");
                isFull.await();
            }
            if (!weights.isEmpty() && totalWeight + weights.getFirst() > 150){
                takeWeight = false;
                isMoved.signalAll();
            }
            else{
                if(weights.isEmpty()){
                    worker.StopWorking();
                    isMoved.signalAll();
                }
                else{
                    totalWeight += weights.pollFirst();
                    System.out.println(totalWeight + " current weight");
                }
            }

        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally {
            locker.unlock();
        }
    }

    public void move(Transfer transfer) {
        locker.lock();
        try{
            while (takeWeight){
                System.out.println("I blocked transfer");
                if(weights.isEmpty()){
                    transfer.StopWorking();
                    return;
                }
                isMoved.await();
            }
            System.out.println("Weights moved");
            takeWeight = true;
            totalWeight = 0;
            isFull.signalAll();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally {
            locker.unlock();
        }
    }

}
