import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.*;

/**
 * @author TemmyTechie
 */

public class SingleExecuteExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Callable<Integer>> callables = new ArrayList<>();

        callables.add(() -> 1);
        callables.add(()-> 2);

        try {
            Thread.sleep(100);
            out.println(executorService.invokeAll(callables));
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
//        executorService.execute(() -> System.out.println("2:" + Math.random() + "Thread id:" + Thread.currentThread().getId()));
//        executorService.execute(() -> System.out.println("3:" + Math.random() + "Thread id:" + Thread.currentThread().getId()));
//        executorService.execute(() -> System.out.println("4:" + Math.random() + "Thread id:" + Thread.currentThread().getId()));

        executorService.shutdown();
    }
}
