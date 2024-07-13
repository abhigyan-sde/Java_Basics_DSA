package Java_Basics.src.main.java.com.understanding.datastructures.Arrays;

public class MinLengthStringafterDeletion {
    public int minimumLength(String s) {
        int start = 0; int end = s.length() - 1;
        int min = s.length();
        while(start < end){
            char a = s.charAt(start);
            char b = s.charAt(end);
            if(a == b){
                start = findSpan(a, start, s, false);
                end = findSpan(b, end, s, true);
                if(start <= end)
                    min = Math.min(end-start+1,min);
                else
                    min = 0;
            }else{
                break;
            }
        }
        return min;
    }

    public int findSpan(char c, int index, String s, boolean reverse){
        if(reverse){
            while(index >= 0 && s.charAt(index) == c){
                index--;
            }
        }else{
            while(index < s.length() && s.charAt(index) == c){
                index++;
            }
        }
        return index;
    }
}
