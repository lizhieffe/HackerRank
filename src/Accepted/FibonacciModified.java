package Accepted;

import java.util.*;
import java.math.*;

public class FibonacciModified {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        BigInteger first = s.nextBigInteger();
        BigInteger second = s.nextBigInteger();
        int n = s.nextInt();
        BigInteger result = new BigInteger("-1");
        if (n <= 0)
            result = BigInteger.valueOf(-1);
        else if (n == 1)
            result = first;
        else if (n == 2)
            result = second;
        else {
            for (int i = 3; i <= n; i ++) {
                result = second.pow(2).add(first);
                first = second;
                second = result;
            }
        }
        System.out.println(result.toString());
    }
}