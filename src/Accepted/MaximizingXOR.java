package Accepted;

import java.util.Scanner;

public class MaximizingXOR {

	static int maxXor(int l, int r) {
        if (l == r)
            return 0;
        int tmp = l ^ r;
        int i = 0;
        while (tmp > 0) {
            tmp = tmp >> 1;
            i ++;
        }
        int result = 0;
        for (int j = 0; j < i; j ++)
            result = (result << 1) + 1;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}
