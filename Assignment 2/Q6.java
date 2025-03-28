public class Q6 {

    public static int parallelBinarySearch(int[] arr, int target) throws InterruptedException {
        int n = arr.length;
        if (n % 10 != 0) {
            throw new IllegalArgumentException("Array length must be divisible by 10.");
        }

        int numThreads = n / 10;
        Thread[] threads = new Thread[numThreads];
        int[] results = new int[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                int start = threadId * 10;
                int end = start + 9;
                results[threadId] = binarySearch(arr, start, end, target);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (int result : results) {
            if (result != -1) {
                return result;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 16;
        int result = parallelBinarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found.");
        }
    }
}
