package Accepted;

import java.util.Scanner;

public class GameOfThronesI {

	public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans = "YES";
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        int[] count = new int[26];
        for (int i = 0; i < inputString.length(); i++)
            count[inputString.charAt(i) - 'a']++;
        
        boolean oneSingle = false;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1 && oneSingle == false)
                oneSingle = true;
            else if (count[i] % 2 == 1) {
                ans = "NO";
                break;
            }
                
        }
        System.out.println(ans);
        myScan.close();
    }
}
