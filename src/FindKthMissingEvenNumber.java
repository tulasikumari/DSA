
    public class FindKthMissingEvenNumber {

        public static void main(String[] args) {
            int[] arr = {0, 2, 6,18, 22};
            int k = 6;
            int result = findKthMissingEvenNumber(arr, k);
            System.out.println("The " + k + "th missing even number from the array is: " + result);
        }

        public static int findKthMissingEvenNumber(int[] arr, int k) {
            int count = 0;
            int prev = -2;
            for (int i = 0; i < arr.length; i++) {
                int diff = arr[i] - prev;
                if (diff > 2) { // there is a missing even number(s) between prev and arr[i]
                    count += diff / 2 - 1;
                    if (count >= k) {
                        return prev + k - (count - diff / 2 + 1) * 2;
                    }
                }
                prev = arr[i];
            }
            // handle the case where k is greater than the total number of missing even numbers
            return arr[arr.length - 1] + (k - count) * 2;
        }
    }

