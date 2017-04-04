
public class Main {
    public static void main(String[] args) {
        final Data data = new Data();

        for(int i = 0; i <2; i++){
            new Consumer(data).start();
        }
        for(int i = 0; i <4; i++){
            new Producer(data).start();
        }


    }
}
