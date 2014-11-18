package Accepted;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TheFullCountingSort {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List[] in = new List[100];
        for (int i = 0; i < in.length; i++)
            in[i] = new LinkedList<String>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            int j = Integer.parseInt(s[0]);
            String st = s[1];
            if(i < n / 2)
                in[j].add("-");
            else
                in[j].add(st);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++)
            if (in[i].size() > 0) {
                for (String s : (List<String>)in[i]) {
                	builder.append(s);
                	builder.append(" ");
            	}
            }
        System.out.println(builder.toString());
    }
}
