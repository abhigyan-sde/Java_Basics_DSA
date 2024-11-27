package Java_Basics.src.main.java.com.understanding.datastructures.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new CustomComparator());
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(result.isEmpty()){
                result.add(intervals[i]);
            }else{
                int[] prev = result.get(result.size() - 1);
                if(intervals[i][0] >= prev[0] && intervals[i][0] <= prev[1]){
                    if(intervals[i][1] > prev[1])
                        prev[1] = intervals[i][1];
                }else if(intervals[i][0] > prev[1]){
                    result.add(intervals[i]);
                }
            }
        }

        int[][] ans = new int[result.size()][2];
        int counter = 0;
        for(int[] res : result){
            ans[counter++] = res;
        }
        return ans;
    }

    public class CustomComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] x, int[] y) {
            if(x[0] == y[0])
            {
                if(y[1] > x[1])
                    return -1;
                else return 1;
            }else{
                if(x[0] < y[0])
                    return - 1;
                else
                    return 1;
            }
        }
    }

}
