package Java_Basics.src.main.java.com.understanding.datastructures.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

//2530. Maximal Score After Applying K Operations
public class MaximalScore {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pqAscend = new PriorityQueue<>();
        long result = 0;
        for(int num : nums){
            pqAscend.offer(num);
            if(pqAscend.size() > k)
                pqAscend.poll();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new ReverseComparator());
        while(pqAscend.size() > 0){
            pq.offer(pqAscend.poll());
        }
        while(k > 0){
            int num = pq.poll();
            result += num;
            num = (int)Math.ceil((double)num/3);
            pq.offer(num);
            k--;
        }
        return  result;
    }

    public class ReverseComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b){
            if(a > b)
                return - 1;
            else
                return 1;
        }
    }
}
