import java.util.concurrent.Callable;

/**
 * @author TemmyTechie
 */

public class CallableThread implements Callable<Object> {
    @Override
    public Object call() throws Exception {

        System.out.println("hi am callable");
        return new Object();
    }
}
