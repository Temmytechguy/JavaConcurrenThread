import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.System.*;

/**
 * @author TemmyTechie
 */

public class CachedThreadPool {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static Future<Double> getRandom(int i)
    {
        return executorService.submit(() -> {
            Thread.sleep((int) Math.random() * 200);
            out.println(i + " Thread id: " + Thread.currentThread().getId());
            Thread.sleep(100);
            return Math.random();
        });
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
         getRandom(i);
        }
        executorService.shutdown();
    }


}
