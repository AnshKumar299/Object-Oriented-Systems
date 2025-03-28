import java.io.*;
import java.util.concurrent.*;

public class Q4 {
    static final int MAX_SIZE = 10;
    static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(MAX_SIZE);

    static class Producer extends Thread {
        private BufferedReader reader;

        public Producer(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line);
                    queue.put(number);
                    System.out.println("Produced: " + number);
                }
                queue.put(-1);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {
        private int sum = 0;

        public void run() {
            try {
                while (true) {
                    int number = queue.take();
                    if (number == -1) {
                        break;
                    }
                    sum += number;
                    System.out.println("Consumed: " + number + ", Current Sum: " + sum);
                }
                System.out.println("Final Sum: " + sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the file path as an argument.");
            return;
        }

        String fileName = args[0];

        Thread producer = new Producer(fileName);
        Thread consumer = new Consumer();

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
