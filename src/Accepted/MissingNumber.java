package Accepted;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        for (int i = 0; i < n1; ++i) {
            int tmp = sc.nextInt();
            if (m1.containsKey(tmp))
                m1.put(tmp, m1.get(tmp) + 1);
            else
                m1.put(tmp, 1);
        }
        int n2 = sc.nextInt();
        Map<Integer, Integer> m2 = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n2; ++i) {
            int tmp = sc.nextInt();
            if (m2.containsKey(tmp))
                m2.put(tmp, m2.get(tmp) + 1);
            else
                m2.put(tmp, 1);
        }
        Set<Integer> missing = new TreeSet<Integer>();
        Iterator<Entry<Integer, Integer>> it = m2.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            int key = entry.getKey();
            int val = entry.getValue();
            if (!m1.containsKey(key) || m1.get(key) != val)
                missing.add(key);
        }
        Iterator<Integer> it1 = missing.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
    }
}
