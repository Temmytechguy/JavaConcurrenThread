/**
 * @author TemmyTechie
 */

public class RunThread implements  Runnable{
    @Override
    public void run() {

        for(int i = 0; i < 10; i++) {
            System.out.println("current thread " + Thread.currentThread().getId() + " id: "  + i);
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                break;

            }
        }
    }
}
