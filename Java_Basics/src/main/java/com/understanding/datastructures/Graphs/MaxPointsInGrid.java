package Java_Basics.src.main.java.com.understanding.datastructures.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;
public class MaxPointsInGrid {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] queries_Sorted = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            queries_Sorted[i] = new int[]{queries[i],i};
        }
        Arrays.sort(queries_Sorted, (a,b) -> a[0] - b[0]);
        int[] result = new int[queries.length];
        int m = grid.length; int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        int[] xDir = new int[]{0,1,0,-1};
        int[] yDir = new int[]{1,0,-1,0};
        int points = 0; visited[0][0] = true;
        for(int[] query : queries_Sorted){
            int val = query[0]; int index = query[1];
            while(pq.size() > 0 && pq.peek()[0] < val){
                int[] current = pq.poll();
                points++;
                for(int k = 0; k < 4; k++){
                    int x = current[1] + xDir[k];
                    int y = current[2] + yDir[k];
                    if(isValid(x,m) && isValid(y,n) && !visited[x][y]){
                        pq.offer(new int[]{grid[x][y], x ,y});
                        visited[x][y] = true;
                    }
                }
            }
            result[index] = points;
        }

        return result;
    }

    private boolean isValid(int a , int b){
        return a >= 0 && a < b;
    }
}
