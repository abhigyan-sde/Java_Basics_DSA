package Java_Basics.src.main.java.com.understanding.datastructures.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithK {
    //[1,2,3,1,2,3,1,2]
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int start = 0; int end = 0;
        int maxLen = 0;
        while(end < nums.length){
            map.put(nums[end], map.getOrDefault(nums[end],0) + 1);
            //Shrink the window
            while(map.get(nums[end]) > k){
                int num = nums[start];
                int freq = map.get(nums[start]) - 1;
                if(freq == 0)
                    map.remove(num);
                else
                    map.put(num,freq);
                start++;
            }
            maxLen = Math.max(end-start+1,maxLen);
            end++;
        }
        return maxLen;
    }
}
