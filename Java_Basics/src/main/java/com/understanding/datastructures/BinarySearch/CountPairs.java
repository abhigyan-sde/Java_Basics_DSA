package Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch;

import java.util.Collections;
import java.util.List;
public class CountPairs {

    /*
       Leetcode - 2824. Count Pairs Whose Sum is Less than Target
     */
    public int countPairs(List<Integer> nums, int target) {
        /*
          Sort the array so that binary search can be applied.
         */
        Collections.sort(nums);
        System.out.println(nums);
        int pairs = 0;
        for(int i = 0; i < nums.size(); i++){
            /*
             For each number check if the number is greater than 0 and greater than target then we don't need to search further and can break
             the loop, because going forward we will always find out pairs to the right of this number which will be greater than the target,
             So no point in checking further. Only if the number is negative and the target is also negative we need to search further right,
             because the negative element summed with another negative element to it's right could bring the pair sum below the target.
             */
            if(nums.get(i) > 0 && nums.get(i) > target)
                break;

            /*
              getCount is an auxiliary function
             */
            pairs += getCount(i, nums, target);

        }
        return pairs;
    }

    public int getCount(int index, List<Integer> nums, int target){
        /*
          Initialize the required variables, start and end will be initialized such that we initiate binary search on the subarray
          always to the right of index.
          lastIndex will be used to store the index of the element for which nums[index] + nums[lastIndex] < target
          This will help in storing the last valid pair and also to continue with binary search if there are more paris to be found.
         */
        int start = index + 1;
        int end = nums.size() - 1;
        int mid = start + (end - start)/2;
        int lastIndex = -1;

        while(start <= end){
            if(nums.get(mid) + nums.get(index) < target){
                start = mid+1;
                lastIndex = mid;
            }else{
                end = mid-1;
            }
            mid = start + (end-start)/2;
        }
        return lastIndex == -1 ? 0 : lastIndex - index ;
    }
}
