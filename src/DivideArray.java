import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArray {
    public static void main(String[] args) {
        DivideArray pa=new DivideArray();

        int[] arr= {5, 2, 4, 11};

        List<List<Integer>> permute = pa.permute(arr);
        System.out.println(pa.getMinimumProdDifference(permute, arr.length));


    }

    public static<T> int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

    private int getMinimumProdDifference(List<List<Integer>> allArr, int n) {
        int ans = Integer.MAX_VALUE;
        for (List<Integer> lst: allArr) {
            int[] arr = lst.stream().mapToInt(i->i).toArray();
            int[] arr1 = subArray(arr, 0, n / 2 -1);
            int[] arr2 = subArray(arr, n/2, n-1);
            int currDiff = Math.abs(getProduct(arr1) - getProduct(arr2));
            ans = Math.min(ans, currDiff);
        }
        return ans;
    }

    private int getProduct(int[] arr) {
        int prod = 1;
        for (int v: arr) {
            prod *= v;
        }
        return prod;
    }
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr){

        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<>(resultList));
        }
        else{
            for(int i = 0; i < arr.length; i++){

                if(resultList.contains(arr[i]))
                {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(arr[i]);
                // Explore
                permuteHelper(list, resultList, arr);
                // Unchoose element
                resultList.remove(resultList.size() - 1);
            }
        }
    }
}
