package Accepted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AngryChildren {

	static BufferedReader in = new BufferedReader(new InputStreamReader(
	         System.in));
	   static StringBuilder out = new StringBuilder();

	   public static void main(String[] args) throws NumberFormatException, IOException {
	      int numPackets = Integer.parseInt(in.readLine());
	      int numKids = Integer.parseInt(in.readLine());
	      int[] packets = new int[numPackets];
	      
	      for(int i = 0; i < numPackets; i ++)
	      {
	         packets[i] = Integer.parseInt(in.readLine());
	      }
	      
	      int unfairness = Integer.MAX_VALUE;
	      
	        // Write your code here, to process numPackets N, numKids K, and the packets of candies
	      // Compute the ideal value for unfairness over here
	      
	      Arrays.sort(packets);
	      for (int i = 0; i < numPackets - numKids; i++) {
	          int beg = packets[i];
	          int end = packets[i + numKids - 1];
	          if (end - beg < unfairness)
	              unfairness = end - beg;
	      }
	      System.out.println(unfairness);
	   }
}
