package Accepted;

import java.util.Scanner;

public class TheMaxSubarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; ++j)
                arr[j] = sc.nextInt();
            System.out.println(maxSubarray(arr) + " " + maxSubsequence(arr));
        }
    }
    
    private static int maxSubarray(int[] array) {
        int max = array[0];
        int sum = max;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] >= 0) {
                if (sum < 0) {
                    sum = array[i];
                }
                else {
                    sum += array[i];
                }
            }
            else {
                if (sum <= 0) {
                    sum = array[i];
                    max = Math.max(sum, max);
                }
                else {
                    max = Math.max(sum, max);
                    sum += array[i];
                }
            }
        }
        max = Math.max(sum, max);
        return max;
    }
    
    private static int maxSubsequence(int[] array) {
        int nonNegativeSum = -1;
        int maxNegative = 1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] >= 0)
                if (nonNegativeSum < 0)
                    nonNegativeSum = array[i];
                else
                    nonNegativeSum += array[i];
            else {
                if (maxNegative > 0)
                    maxNegative = array[i];
                else
                    maxNegative = Math.max(maxNegative, array[i]);
            }
        }
        if (nonNegativeSum >= 0)
            return nonNegativeSum;
        else
            return maxNegative;
    }
}
