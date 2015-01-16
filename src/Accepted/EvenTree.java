package Accepted;

import java.util.Scanner;

public class EvenTree {
    
    static int result = 0;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        int[][] neighbors = new int[vertex][vertex];
        for (int k = 0; k < edges; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            neighbors[i - 1][j - 1] = 1;
            neighbors[j - 1][i - 1] = 1;
        }
        int[] color = new int[vertex];
        if (vertex == 0 || vertex % 2 == 1) {
            System.out.println("-1");
            return;
        }
        findSubTreeVertex(0, neighbors, color);
        System.out.println(result);
    }
    
    private static int findSubTreeVertex(int index, int[][] neighbors, int[] color) {
        color[index] = 1;
        int num = 1;
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[index][i] == 1 && color[i] == 0) {
                int subTreeVertex = findSubTreeVertex(i, neighbors, color);
                if (subTreeVertex % 2 == 0)
                    ++result;
                num += subTreeVertex;
            }
        }
        return num;
    }
}
