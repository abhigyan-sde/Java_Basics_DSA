package Java_Basics.src.main.java.com.understanding.datastructures;

import Java_Basics.src.main.java.com.understanding.datastructures.Arrays.LengthOfLongestSubarrayWithK;
import Java_Basics.src.main.java.com.understanding.datastructures.Arrays.RobotCollisions;


public class App 
{
    public static void main( String[] args )
    {
        RobotCollisions rc = new RobotCollisions();
        rc.survivedRobotsHealths(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10},"RRRRR");
        LengthOfLongestSubarrayWithK lenK= new LengthOfLongestSubarrayWithK();
        lenK.maxSubarrayLength(new int[]{1,2,1,1}, 1);
    }
}
