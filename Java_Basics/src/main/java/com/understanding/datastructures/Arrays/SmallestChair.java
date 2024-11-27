package Java_Basics.src.main.java.com.understanding.datastructures.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestChair {
    // j -> [1,4,] | [2, 3 , ] | [4,6,]
    // i -> [2, 3 , ] | 1 , 4, ] | [4,6,]
    public int smallestChair(int[][] times, int targetFriend) {
       List<Friend> friendListStart = new ArrayList<>();
        List<Friend> friendListEnd = new ArrayList<>();
        int[] target = times[targetFriend];
       for(int i = 0; i < times.length; i++){
           Friend friend = new Friend(times[i][0], times[i][1],i);
           friendListStart.add(friend);
           friendListEnd.add(friend);
       }
       friendListStart.sort(Comparator.comparingInt(x -> x.arrival));
       friendListEnd.sort(Comparator.comparingInt(x -> x.departure));
       int chair = 0;
       int i = 0; int j = 0;
       while(i < friendListEnd.size() && j < friendListStart.size()){
           if(friendListStart.get(j).arrival < friendListEnd.get(i).departure){
               friendListStart.get(j).chair = chair;
               chair++;
               j++;
           }else{
               chair--;
               i++;
           }
       }

       return friendListStart.stream()
               .filter(x -> x.arrival == target[0] && x.departure == target[1])
               .findFirst().get().chair;

    }

    public class Friend{
        int arrival;
        int departure;
        int chair;
        int index;
        public Friend(int arrival, int departure, int index){
            this.arrival = arrival;
            this.departure = departure;
            this.index = index;
        }
    }
}
