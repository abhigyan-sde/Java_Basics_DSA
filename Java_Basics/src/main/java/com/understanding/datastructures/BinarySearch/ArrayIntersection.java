package Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntersection {
    /*
        1213. Intersection of Three Sorted Arrays
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        for(int num : arr1){
            if(exists(arr2,num) && exists(arr3,num))
                result.add(num);
        }
        return result;
    }

    public boolean exists(int[] arr, int target){
        int start = 0; int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
