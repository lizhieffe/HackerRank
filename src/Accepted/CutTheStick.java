package Accepted;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CutTheStick {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; ++i) {
            int val = sc.nextInt();
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            }
            else {
                map.put(val, 1);
                pq.add(val);
            }
        }
        while (n > 0) {
            System.out.println(n);
            n -= map.remove(pq.poll());
        }
    }
}
