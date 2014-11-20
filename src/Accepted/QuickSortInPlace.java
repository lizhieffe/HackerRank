package Accepted;

import java.util.Scanner;

public class QuickSortInPlace {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        sort(array, 0, array.length - 1);
    }
    
    private static void sort(int[] array, int beg, int end) {
        if (end - beg <= 0)
            return;
        int last = beg;
        for (int i = beg; i <= end; i++) {
            if (i == end || array[i] < array[end]) {
                int tmp = array[i];
                array[i] = array[last];
                array[last] = tmp;
                last++;
            }
            if (i == end)
                last--;
        }
        print(array);
        sort(array, beg, last - 1);
        sort(array, last + 1, end);
    }
    
    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
