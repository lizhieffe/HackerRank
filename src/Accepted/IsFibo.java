package Accepted;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsFibo {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        long val = 0;
        Set<Long> hash = new HashSet<Long>();
        hash.add((long) 0);
        hash.add((long) 1);
        hash.add((long) 2);
        val = 2;
        long first = 1;
        long second = 2;
        while (val < 10000000000L) {
            val = first + second;
            hash.add(val);
            first = second;
            second = val;
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long tmp = sc.nextLong();
            if (hash.contains(tmp))
                System.out.println("IsFibo");
            else
                System.out.println("IsNotFibo");
        }
    }
}
