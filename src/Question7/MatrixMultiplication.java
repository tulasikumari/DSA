package Question7;

// 7a done
//Implement multi-threaded algorithm to multiply n*n matrix.
public class MatrixMultiplication {

    private static int[][] A;
    private static int[][] B;
    private static int[][] C;
    private static int n;
    private static int numThreads;

    public static void main(String[] args) {
        n = 1000;
        numThreads = 4;
        A = new int[n][n];
        B = new int[n][n];
        C = new int[n][n];

        // Initialize matrices A and B with random values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = (int) (Math.random() * 100);
                B[i][j] = (int) (Math.random() * 100);
            }
        }

        // Create threads to multiply slices of the matrices
        Thread[] threads = new Thread[numThreads];
        int sliceSize = n / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * sliceSize;
            int end = (i + 1) * sliceSize;
            threads[i] = new Thread(new MatrixMultiplier(start, end));
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class MatrixMultiplier implements Runnable {

        private int start;
        private int end;

        public MatrixMultiplier(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
    }
}