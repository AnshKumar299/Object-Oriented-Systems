public class Q1 {

    public static void main(String[] args) {
        System.out.println("In main thread");

        Thread childThread = new Thread(() -> {
            System.out.println("In child thread");
        });

        childThread.start();

        try {
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
