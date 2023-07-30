import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author TemmyTechie
 */

public class Counter {

   public static int counter = 0;
   public static Lock lock = new ReentrantLock();



    public static  void incrementCounter() throws InterruptedException {
        if(lock.tryLock())
        {
            try{

                int current = counter;
                System.out.println("Before : " + counter + " current thread " + Thread.currentThread().getId() );
                counter = current + 1;
                System.out.println("After : " + counter + " current thread " + Thread.currentThread().getId() );

            }finally {
                lock.unlock();
            }
        }
        else{
            System.out.println("Thread lock and looking for a new task");
        }


    }

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
                Thread t1 = new Thread(() -> {
                    try {
                        incrementCounter();
                    } catch (InterruptedException e) {
                       e.printStackTrace();                    }
                });
            t1.start();
        }
    }
}
