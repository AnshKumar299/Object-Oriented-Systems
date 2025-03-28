public class Q3 {
    static double result = 0;
    static final int N = 10;
    static long[] factorials = new long[N];

    static class GenerateDenominators extends Thread {
        public void run() {
            for (int i = 1; i <= N; i++) {
                factorials[i - 1] = factorial(i);
            }
        }

        private long factorial(int num) {
            long fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            return fact;
        }
    }

    static class ComputeSeries extends Thread {
        public void run() {
            synchronized (Q3.class) {
                for (int i = 1; i <= N; i++) {
                    result += 1.0 / factorials[i - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new GenerateDenominators();
        Thread t2 = new ComputeSeries();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The result of the series is: " + (1 + result));
    }
}
