package Java_Basics.src.main.java.com.understanding.datastructures.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MinArrows {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new CustomComparator());
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < points.length; i++){
            if(stack.isEmpty()){
                stack.push(points[i]);
            }else{
                //If the previous intersection area intersects with the balloon then merge the interval
                if(points[i][0] <= stack.peek()[1]){
                    int[] prevPoint = stack.pop();
                    prevPoint[0] = Math.max(prevPoint[0], points[i][0]);
                    prevPoint[1] = Math.min(prevPoint[1], points[i][1]);
                    stack.push(prevPoint);
                }else{
                    stack.push(points[i]);
                }
            }
        }

        return stack.size();
    }

    public class CustomComparator implements Comparator<int[]>{
        @Override
        public int compare(int[]a, int[]b){
            if(a[0] == b[0])
                return Integer.compare(a[1],b[1]);
            else
                return Integer.compare(a[0], b[0]);
        }
    }
}
