package Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch;

public class MaximumCountOfPositiveAndNegative {
    public int maximumCount(int[] nums) {
        int posCount = getPositiveCount(nums);
        int negCount = getNegativeCount(nums);
        return Math.max(posCount,negCount);
    }

    public int getPositiveCount(int[] nums){
        int start = 0; int end = nums.length - 1;
        int index = -1;
        while(start <= end){
            int mid = start + (end- start)/2;

            if(nums[mid] > 0){
                end = mid-1;
                index = mid;
            }else{
                start = mid + 1;
            }
        }

        return index == -1 ? 0 : nums.length - index;
    }

    public int getNegativeCount(int[] nums){
        int start = 0; int end = nums.length - 1;
        int index = -1;
        while(start <= end){
            int mid = start + (end- start)/2;

            if(nums[mid] < 0){
                start = mid + 1;
                index = mid;
            }else{
                end = mid - 1;
            }
        }

        return index == -1 ? 0 : index + 1;
    }
}
