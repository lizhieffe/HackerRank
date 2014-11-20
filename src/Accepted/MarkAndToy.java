package Accepted;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToy {

	public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();
        
        int answer = 0;
        // Compute the final answer from n,k,prices 
        Arrays.sort(prices);
        while (true) {
            if (k > prices[answer]) {
                k -= prices[answer];
                answer++;
            }
            else
                break;
        }
        System.out.println(answer);
    }
}
