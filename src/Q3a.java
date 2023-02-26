import java.util.Arrays;

public class Q3a {
    public static void main(String[] args) {
        int [] arr={5,2,4,11};
        int n=arr.length;
        int mid=arr.length/2;
        int [] left_half= Arrays.copyOfRange(arr,0,mid);
        int [] right_half= Arrays.copyOfRange(arr,mid,arr.length);
        System.out.println("First half: " + Arrays.toString(left_half));
        System.out.println("Second half: " + Arrays.toString(right_half));

    }

}
