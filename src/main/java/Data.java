import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final Logger LOG =LoggerFactory.getLogger(Data.class);

    private int counter = 0;

    private final static int OLDEST_ELEMENT = 0;

    private final static int MAX_SIZE = 100;

    private final List<String> sharedMemory;

    public Data() {
        sharedMemory = new ArrayList<String>();
    }

    public synchronized void addData(final String data) throws InterruptedException {
        if (sharedMemory.size() < MAX_SIZE) {
            System.out.println(counter + " got produced!");
            sharedMemory.add("Counter: "+ counter++);
        }
        try {
            notifyAll();
            System.out.println("Producer  ... waiting");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void consume() throws InterruptedException {
        if (sharedMemory.size() > 0) {
            final String removed = sharedMemory.get(OLDEST_ELEMENT);
            sharedMemory.remove(OLDEST_ELEMENT);
            System.out.println(removed + " got consumed!");
        }
        try {
            notifyAll();
            System.out.println("consumer...waiting");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
