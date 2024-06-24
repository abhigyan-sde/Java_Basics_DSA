package Java_Basics.src.main.java.com.understanding.datastructures;

import Java_Basics.src.main.java.com.understanding.datastructures.BinarySearch.CountPairs;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CountPairs bs = new CountPairs();
        Integer[] arr = new Integer[]{-6,2,5,-2,-7,-1,3};
        bs.countPairs(Arrays.stream(arr).collect(Collectors.toList()), -2);
    }
}
