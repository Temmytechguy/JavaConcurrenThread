public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RunThread());
        t1.start();

        t1.join(1500);
        Thread t2 = new Thread(new RunThread());
        t2.start();
    }
}