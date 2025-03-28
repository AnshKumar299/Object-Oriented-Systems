public class Q5 {
    static int oddSum = 0;
    static int evenSum = 0;

    static class OddSumThread extends Thread {
        public void run() {
            for (int i = 1; i <= 99; i += 2) {
                oddSum += i;
            }
        }
    }

    static class EvenSumThread extends Thread {
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                evenSum += i;
            }
        }
    }

    public static void main(String[] args) {
        Thread oddThread = new OddSumThread();
        Thread evenThread = new EvenSumThread();

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int finalSum = oddSum + evenSum;
        System.out.println("The final sum is: " + finalSum);
    }
}
