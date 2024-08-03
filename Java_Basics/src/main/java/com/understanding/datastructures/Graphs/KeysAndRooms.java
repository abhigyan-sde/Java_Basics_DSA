package Java_Basics.src.main.java.com.understanding.datastructures.Graphs;

import java.util.*;

public class KeysAndRooms {
    /*
     There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
     Your goal is to visit all the rooms.
     However, you cannot enter a locked room without having its key.
     When you visit a room, you may find a set of distinct keys in it.
     Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
     Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
      return true if you can visit all the rooms, or false otherwise.
     */

    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        performDFS(0,rooms,visited);
        for(int i = 0; i < n; i++){
            if(!visited[i])
                return false;
        }
        return true;
    }

    private void performDFS(int room, List<List<Integer>> rooms, boolean[] visited){
        if(visited[room])
            return;

        visited[room] = true;
        for(int key : rooms.get(room)){
            performDFS(key, rooms, visited);
        }
    }
    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        int n = rooms.size();
        List<Integer>[] adjacencyList = new List[n];

        for(int i = 0; i < n ; i++){
            adjacencyList[i] = new ArrayList<>();
            for(int key : rooms.get(i)){
                adjacencyList[i].add(key);
            }
        }

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()){
            int room = queue.poll();
            visited.add(room);
            for(int key : adjacencyList[room]){
                if(!visited.contains(key)){
                    queue.offer(key);
                }
            }
        }

        return visited.size() == n;
    }
}
