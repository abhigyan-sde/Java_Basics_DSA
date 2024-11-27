package Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumBeauty {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, new CustomComparator());
        int[] result = new int[queries.length];
        int max = 0;
        for(int[] item : items){
            max = Math.max(max, item[1]);
            item[1] = max;
        }
        for(int i = 0; i < queries.length; i++){
            result[i] = findMaxBeauty(queries[i], items);
        }
        return result;
    }

    public int findMaxBeauty(int query, int[][] items){
        int start = 0; int end = items.length - 1;
        int price = 0;
        while(start <= end){
            int mid = start + (end - start)/2 ;

            if(items[mid][0] <= query){
                price = items[mid][1];
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return price;
    }

    public class CustomComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] a, int[] b) {
           if(a[0] == b[0])
               return Integer.compare(a[1],b[1]);
           else
               return Integer.compare(a[0],b[0]);
        }
    }
}
