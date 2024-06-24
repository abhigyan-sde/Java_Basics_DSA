package Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch;

import java.util.Arrays;

public class LongestSSWithLimitedSum {
    /*
     #LeetCode
     2389. Longest Subsequence With Limited Sum
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        //Sort the array so we can apply binary search
        Arrays.sort(nums);

        //Get the running sum for each element
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }

        /*
          Now we have the running sum for the sorted array, so this problem reduces to the point where for every value in queries we just need to
          calculate how many runningSums are <= query. Because running Sum is formed by adding the elements in the sorted array and in this case
          the problem states that we will always have +ve integers therefore we can sort the array and take a running sum without worrying about
          the sequence. Now calculating the count comes down to doing a Binary Search where we want to check how many runningSum elements are
          less than the query or target.
         */
        for(int i = 0; i < queries.length; i++){
            result[i] = getCount(nums,queries[i]);
        }
        return result;
    }

    /*
     Binary Search function for finding the count.
     */
    public int getCount(int[] arr, int target){
        int start = 0; int end = arr.length -1;
        int index = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] <= target){
                index = mid;
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return index == -1 ? 0 : index + 1;
    }
}
