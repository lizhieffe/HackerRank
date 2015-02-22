package Accepted;

import java.util.Scanner;

public class SharlockAndArray {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            if (n == 1) {
                System.out.println("YES");
                continue;
            }
            int left = 0;
            int right = sum - arr[0];
            String found = "NO";
            for (int j = 1; j < n - 1; ++j) {
                left += arr[j - 1];
                right -= arr[j];
                if (left == right) {
                    found = "YES";
                    break;
                }
            }
            System.out.println(found);
        }
    }
}
