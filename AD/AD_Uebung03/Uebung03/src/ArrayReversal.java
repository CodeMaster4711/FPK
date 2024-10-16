import java.util.Arrays;

public class ArrayReversal {

    public static void reverseArray(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    // test client
    public static void main (String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Original array: " + Arrays.toString(test));
        reverseArray(test);
        System.out.println("After reversal: " + Arrays.toString(test));
    }
}
