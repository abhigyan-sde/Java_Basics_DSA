package Java_Basics.src.main.java.com.understanding.datastructures.Graphs;

import java.util.*;

public class CourseScheduleII {
    //BFS solution
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites){
            int to = edge[0];
            int from = edge[1];

            if(!map.containsKey(from))
                map.put(from, new ArrayList<>());

            map.get(from).add(to);
            indegree[to] += 1;
        }

        Queue<Integer> bfs = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                bfs.offer(i);
        }
        List<Integer> result = new ArrayList<Integer>();
        while(bfs.size() > 0){
            int course = bfs.poll();
            result.add(course);
            if(map.containsKey(course)){
                for(int neighbor : map.get(course)){
                    indegree[neighbor] -= 1;
                    if(indegree[neighbor] == 0)
                        bfs.offer(neighbor);
                }
            }
        }

        return result.size() == numCourses ?  result.stream().mapToInt(Integer::intValue).toArray()
                : new int[0];
    }
}
