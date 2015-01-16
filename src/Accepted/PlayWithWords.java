package Accepted;

import java.util.Scanner;

public class PlayWithWords {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        if (c.length <= 1)
            System.out.println(c.length);
        int result = 0;
        PlayWithWords service = new PlayWithWords();
        int[][] dp = new int[c.length][c.length];
        for (int i = 0; i < c.length - 1; ++i) {
            int tmp = service.find(c, 0, i, dp) * service.find(c, i + 1, c.length - 1, dp);
            if (tmp > result)
                result = tmp;
        }
        System.out.println(result);
    }
    
	private int find(char[] arr, int beg, int end, int[][] dp) {
		if (beg > end)
			return 0;
		if (beg == end)
			return 1;
		if (dp[beg][end] != 0)
			return dp[beg][end];
		int result;
		if (arr[beg] == arr[end])
			result = 2 + find(arr, beg + 1, end - 1, dp);
		else
			result = Math.max(find(arr, beg + 1, end, dp), find(arr, beg, end - 1, dp));
		dp[beg][end] = result;
		return result;
	}
}
