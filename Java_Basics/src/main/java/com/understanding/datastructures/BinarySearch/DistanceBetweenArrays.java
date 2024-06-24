package Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch;

import java.util.Arrays;

public class DistanceBetweenArrays {
    /*
    1385. Find the Distance Value Between Two Arrays
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distance = 0;

        for(int val : arr1){
            if(distanceExists(arr2, val - d, val + d)){
                distance += 1;
            }
        }
        return distance;
    }

    public boolean distanceExists(int[] arr, int lower, int higher){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2 ;
            if(arr[mid] >= lower && arr[mid] <= higher)
                return false;
            else if(arr[mid] < lower)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return true;
    }
}
