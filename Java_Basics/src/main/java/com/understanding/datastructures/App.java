package Java_Basics.src.main.java.com.understanding.datastructures;


import Java_Basics.src.main.java.com.understanding.datastructures.Arrays.MaximalScore;

public class App
{
    public static void main( String[] args )
    {
        int[] nums = new int[]{1,10,3,3,3};
        MaximalScore maximalScore = new MaximalScore();
        maximalScore.maxKelements(nums, 3);
    }
}
