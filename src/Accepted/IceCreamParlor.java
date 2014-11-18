package Accepted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IceCreamParlor {

	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        for (int i = 0 ; i < t; i++) {
	       int m = sc.nextInt();
	       int n = sc.nextInt();
	       Node[] c = new Node[n];
	       for (int j = 0; j < n; j++)
	       
	c[j] = new Node(sc.nextInt(), j);
	       Arrays.sort(c, new NodeComparator());
	       int p1 = 0;
	       int p2 = c.length - 1;
	       while (p1 < p2) {
	       
	if (c[p1].val + c[p2].val == m) {
	       
	System.out.println((Math.min(c[p1].index, c[p2].index) + 1) + " " + (Math.max(c[p1].index, c[p2].index) + 1));
	       
	break;
	       
	}
	       
	else if (c[p1].val + c[p2].val < m)
	       
	p1++;
	       
	else
	       
	p2--;
	       }
	        }
	    }
	}

	class Node {
	int val;
	int index;
	Node (int val, int index) {
	this.val = val;
	this.index = index;
	}
	}

	class NodeComparator implements Comparator <Node> {
	public int compare (Node n1, Node n2) {
	if (n1.val > n2.val)
	return 1;
	else if (n1.val < n2.val)
	return -1;
	else
	return 0;
	}
	}
