package Accepted;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountLuck {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] forest = new char[m][n];
            sc.nextLine();
            for (int j = 0; j < m; j++)
                forest[j] = sc.nextLine().toCharArray();
            int steps = sc.nextInt();
            
            if (steps == getSteps(forest))
                System.out.println("Impressed");
            else
                System.out.println("Oops!");
            //System.out.println(getSteps(forest));
        }
    }
    
    private static int getSteps(char[][] forest) {
        int[][] steps = new int[forest.length][forest[0].length];
        int[][] color = new int[forest.length][forest[0].length];
        Queue<CLPoint> queue = new LinkedList<CLPoint>();
        for (int i = 0; i < forest.length; i++)
            for (int j = 0; j < forest[0].length; j++)
                if (forest[i][j] == 'M') {
                    queue.add(new CLPoint(i, j));
                    steps[i][j] = 0;
                    color[i][j] = 2;
                    break;
                }
        
        while (queue.size() > 0) {
        	CLPoint p = queue.poll();
            int x = p.x;
            int y = p.y;
            color[x][y] = 2;
            if (forest[x][y] == '*')
                return steps[x][y];
            int count = 0;
            if (x > 0 && forest[x - 1][y] != 'X' && color[x - 1][y] == 0)
                count++;
            if (x < forest.length - 1 && forest[x + 1][y] != 'X' && color[x + 1][y] == 0)
                count++;
            if (y > 0 && forest[x][y - 1] != 'X' && color[x][y - 1] == 0)
                count++;
            if (y < forest[0].length - 1 && forest[x][y + 1] != 'X' && color[x][y + 1] == 0)
                count++;
            if (count > 2)
                count = 2;
            if (x > 0 && forest[x - 1][y] != 'X' && color[x - 1][y] == 0) {
                queue.add(new CLPoint(x - 1, y));
                steps[x - 1][y] = steps[x][y] + count / 2;
                color[x - 1][y] = 1;
            }
            if (x < forest.length - 1 && forest[x + 1][y] != 'X' && color[x + 1][y] == 0) {
                queue.add(new CLPoint(x + 1, y));
                steps[x + 1][y] = steps[x][y] + count / 2;
                color[x + 1][y] = 1;
            }
            if (y > 0 && forest[x][y - 1] != 'X' && color[x][y - 1] == 0) {
                queue.add(new CLPoint(x, y - 1));
                steps[x][y - 1] = steps[x][y] + count / 2;
                color[x][y - 1] = 1;
            }
            if (y < forest[0].length - 1 && forest[x][y + 1] != 'X' && color[x][y + 1] == 0) {
                queue.add(new CLPoint(x, y + 1));
                steps[x][y + 1] = steps[x][y] + count / 2;
                color[x][y + 1] = 1;
            }
        }
        return -1;
    }
    
    

}

class CLPoint {
    int x;
    int y;
    CLPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
