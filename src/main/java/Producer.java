
public class Producer extends Thread {

    private static int counter = 0;

    private final Data data;


    public Producer(final Data data){
        this.data = data;
    }

    public void run(){
        while(true) {
            try {
                Thread.sleep(1000);
                data.addData("Process Number: " + String.valueOf(this.getId()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
