// 8 b

import java.util.HashSet;
import java.util.Set;

public class FindKthMissingEvenNumber {
    public static int findKthMissingEvenNumber(int[] a, int k) {
        int check = 0;
        int n = a.length;
        int max = a[n-1];
        int i = 0;
        int ans = 0;

        Set<Integer> present = new HashSet<>();
        for (int cur: a) {
            present.add(cur);
        }
        while (k > 0) {
            if (!present.contains(check)) {
                ans = check;
                k -= 1;
            }
            check += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 6, 18, 22};
        int k = 6;
        int kthMissingEvenNumber = findKthMissingEvenNumber(a, k);
        System.out.println("Kth missing even number: " + kthMissingEvenNumber);
    }
}