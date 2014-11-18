package Accepted;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CuttingBoards {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
        long result = 0;
        int m = sc.nextInt();
        int n = sc.nextInt();
        PriorityQueue<Long> c1 = new PriorityQueue<Long>(m - 1, Collections.reverseOrder());
        PriorityQueue<Long> c2 = new PriorityQueue<Long>(n - 1, Collections.reverseOrder());
        for (int j = 0; j < m - 1; j++)
        c1.add(sc.nextLong());
        for (int j = 0; j < n - 1; j++)
        c2.add(sc.nextLong());
        while (c1.size() + c2.size() > 0) {
        if (c2.size() == 0)
        result += c1.poll() * n;
        else if (c1.size() == 0)
        result += c2.poll() * m;
        else {
        long v1 = c1.peek();
        long v2 = c2.peek();
        if (v1 > v2)
        result += c1.poll() * (n - c2.size());
        else
        result += c2.poll() * (m - c1.size());
       
        }
        }
        System.out.println(result % 1000000007L);
        }
    }
}