package Java_Basics.src.main.java.com.understanding.datastructures.Graphs;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ReorderPaths {
    /*
    There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree).
     Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
    Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
    Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
    It's guaranteed that each city can reach city 0 after reorder.
     */
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for(int[] connection : connections){
            if(!adjacencyList.containsKey(connection[0]))
                adjacencyList.put(connection[0], new ArrayList<>());
            adjacencyList.get(connection[0]).add(new int[]{connection[1],1});

            if(!adjacencyList.containsKey(connection[1]))
                adjacencyList.put(connection[1], new ArrayList<>());
            adjacencyList.get(connection[1]).add(new int[]{connection[0],0});
        }
        doDFS(0,-1,adjacencyList);
        return count;
    }

    public void doDFS(int city, int parent, Map<Integer, List<int[]>> adjacencyList){
        if(!adjacencyList.containsKey(city))
            return;

        for(int[] neighbor : adjacencyList.get(city)){
            if(parent != neighbor[0]){
                count += neighbor[1];
                doDFS(neighbor[0], city, adjacencyList);
            }
        }
    }
}
