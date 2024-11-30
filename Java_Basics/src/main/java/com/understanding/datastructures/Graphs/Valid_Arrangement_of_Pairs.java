package Java_Basics.src.main.java.com.understanding.datastructures.Graphs;

import java.util.*;

//2097. Valid Arrangement of Pairs
public class Valid_Arrangement_of_Pairs {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        Map<Integer,Integer> outdegree = new HashMap<>();

        for(int[] pair : pairs){
            if(!adjList.containsKey(pair[0]))
                adjList.put(pair[0], new ArrayList<>());

            adjList.get(pair[0]).add(pair[1]);
            indegree.put(pair[1], indegree.getOrDefault(pair[1],0) + 1);
            outdegree.put(pair[0], outdegree.getOrDefault(pair[0],0) + 1);
        }

        int source = pairs[0][0];

        for(int key : outdegree.keySet()){
            if(!indegree.containsKey(key) || indegree.get(key) < outdegree.get(key)){
                source = key;
                break;
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        List<Integer> result = new ArrayList<>();
        while(stack.size() > 0){
            while(adjList.containsKey(stack.peek())){
                int next = adjList.get(stack.peek()).get(0);
                adjList.get(stack.peek()).remove(0);
                if(adjList.get(stack.peek()).isEmpty())
                    adjList.remove(stack.peek());

                stack.push(next);
            }
            result.add(stack.pop());
        }

        int[][] answer = new int[pairs.length][2];
        int index = 0;
        for(int i = result.size() - 1; i >=0; i--){
            if(i != result.size() - 1 && i != 0){
                answer[index++][1] = result.get(i);
                answer[index][0] = result.get(i);
            }else if (i == 0){
                answer[index][1] = result.get(i);
            }
            else{
                answer[index][0] = result.get(i);
            }
        }
        return answer;
    }
}
