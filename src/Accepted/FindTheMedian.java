package Accepted;

import java.util.Random;
import java.util.Scanner;

public class FindTheMedian {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        System.out.println(find(arr, 0, n - 1, n / 2 + 1));
    }
    
    private static int find(int[] arr, int beg, int end, int target) {
        if (target == 0) {
            int min = Integer.MAX_VALUE;
            for (int i = beg; i <= end; ++i)
                if (min > arr[i])
                    min = arr[i];
            return min;
        }
        if (target == end - beg + 1) {
            int max = Integer.MIN_VALUE;
            for (int i = beg; i <= end; ++i)
                if (max < arr[i])
                    max = arr[i];
            return max;
        }
        Random rand = new Random(47);
        int tmp = rand.nextInt(end - beg);
        swap(arr, tmp + beg, end);
        int mid = beg;
        for (int i = beg; i < end; ++i) {
            if (arr[i] <= arr[end]) {
                swap(arr, i, mid++);
            }
        }
        if (mid - beg == target - 1)
            return arr[end];
        if (mid - beg > target - 1)
            return find(arr, beg, mid - 1, target);
        return find(arr, mid, end - 1, target - (mid - beg) - 1);
    }
    
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
