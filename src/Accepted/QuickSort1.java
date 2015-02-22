package Accepted;

import java.util.Scanner;
public class QuickSort1 {
       
       static void partition(int[] ar) {
        int smaller = 0;
           
       for (int i = 1; i < ar.length; ++i) {
           if (ar[0] > ar[i])
        	   ++smaller;
       }
       int[] newAr = new int[ar.length];
       newAr[smaller] = ar[0];
       int i = 0;
       int j = smaller + 1;
       for (int k = 1; k < ar.length; ++k) {
           if (ar[0] > ar[k])
               newAr[i++] = ar[k];
           else
               newAr[j++] = ar[k];
       }
           System.arraycopy(newAr, 0, ar, 0, ar.length);
   }   

 static void printArray(int[] ar) {
     for(int n: ar){
        System.out.print(n+" ");
     }
       System.out.println("");
  }
   
  public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[] ar = new int[n];
       for(int i=0;i<n;i++){
          ar[i]=in.nextInt(); 
       }
       partition(ar);
       printArray(ar);
   }  
   }

