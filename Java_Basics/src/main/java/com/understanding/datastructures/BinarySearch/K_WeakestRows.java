package Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch;

import java.util.PriorityQueue;

public class K_WeakestRows {
    /*
       1337. The K Weakest Rows in a Matrix
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            else
                return b[0] - a[0];
        });

        for(int i = 0; i < mat.length; i++){
            int strength = getStrengthUsingBinarySearch(mat[i],0);
            priorityQueue.offer(new int[]{strength, i});

            if(priorityQueue.size() > k)
                priorityQueue.poll();
        }

        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--){
            int[] temp = priorityQueue.poll();
            result[i] = temp[1];
        }
        return result;
    }

    public int getStrengthUsingBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int firstIndexOfTarget = -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == 0){
                end = mid - 1;
                firstIndexOfTarget = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return firstIndexOfTarget == -1 ? arr.length : firstIndexOfTarget;
    }
}
