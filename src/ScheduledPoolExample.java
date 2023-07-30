import java.util.concurrent.*;

import static java.lang.System.out;

/**
 * @author TemmyTechie
 */

public class ScheduledPoolExample {


    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);


    public static void main(String[] args) {
        Future<Double> doubleScheduledFuture = executorService.schedule(() -> {
            Thread.sleep((int) Math.random() * 200);
            out.println(1 + " Thread id: " + Thread.currentThread().getId());
            Thread.sleep(100);
            return Math.random();
        }, 1000, TimeUnit.MILLISECONDS);


        try {
            out.println(doubleScheduledFuture.get());
        } catch (InterruptedException e) {
e.printStackTrace();
        } catch (ExecutionException e) {
e.printStackTrace();
        }

        if(doubleScheduledFuture.isCancelled())
        {
            out.println("Very sorry but future was cancelled..");
        }

        if(doubleScheduledFuture.isDone())
        {
            out.println("future has completed");
        }

        executorService.shutdown();


    }
}
