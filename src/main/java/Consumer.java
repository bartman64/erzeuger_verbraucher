
public class Consumer extends Thread {

    private final Data data;

    public Consumer(final Data data) {
        this.data = data;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(200);
                data.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}