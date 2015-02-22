package Accepted;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int columns = (int)Math.ceil(Math.sqrt(s.length()));
        int rows = (int)Math.floor(Math.sqrt(s.length()));
        if (rows < columns && rows * columns < s.length())
            ++rows;
        char[] c = s.toCharArray();
        for (int j = 0; j < columns; ++j) {
            for (int i = 0; i < rows; ++i)
                if (i * columns + j < s.length())
                    System.out.print(c[i * columns + j]);
            System.out.print(" ");
        }
    }
}
