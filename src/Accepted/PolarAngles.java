package Accepted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PolarAngles {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
        }
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
        points[i] = new Point(x[i], y[i], i);
        }
        Arrays.sort(points, new PointComparator());
        for (int i = 0; i < n; i++) {
        int j = points[i].index;
        System.out.println(x[j] + " " + y[j]);
        }
    }

}

class Point {
	double r;
	double degree;
	int index;
	Point(int x, int y, int id) {
		r = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
		index = id;
		if (x == 0 && y == 0)
			degree = 0;
		else if (x == 0 && y > 0)
			degree = 90;
		else if (x == 0 && y < 0)
			degree = 270;
		else if (y == 0 && x > 0)
			degree = 0;
		else if (y == 0 && x < 0)
			degree = 180;
		else {
			degree = Math.toDegrees(Math.atan((double)y / (double)x));
			if (degree < 0)
				degree += 180;
			if (y < 0)
				degree += 180;
		}
	}
}

class PointComparator implements Comparator <Point> {
	public int compare (Point p1, Point p2) {
		if (p1.degree < p2.degree)
			return -1;
		if (p1.degree > p2.degree)
			return 1;
		if (p1.r < p2.r)
			return -1;
		if (p1.r > p2.r)
			return 1;
		return 0;
	}
}
