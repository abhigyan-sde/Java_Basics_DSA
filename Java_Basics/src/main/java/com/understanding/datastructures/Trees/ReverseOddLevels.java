package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseOddLevels {
    /*
        2415. Reverse Odd Levels of Binary Tree
         This question can be asked as reversing the values of the nodes in odd level or reversing the nodes in place. We should clarify
         with the interviewer regarding the ask and then move forward with the solution.
         I have provided the solution for both the cases.
         1) For reversing nodes (only value), we can simply do a DFS on the left and right subtree and keep a counter to know the
         level we are at and at any odd level, we just swap the node values of left and right node.

         2) For reversing the nodes in place we can create a HashMap which will give us the list of Nodes at each level. And then for all
         the keys in the hashmap anytime we come across a level which is even and if level+1 exists then we map the nodes in level with
         nodes in reverse Order in level + 1.
     */

    /****************** Approach 1 ************/

    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevelHelper(root.left,root.right,1);
        return root;
    }

    public void reverseOddLevelHelper(TreeNode left, TreeNode right, int level){
        if(left == null || right == null)
            return;

        if(level % 2 == 1){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        reverseOddLevelHelper(left.left, right.right, level + 1);
        reverseOddLevelHelper(left.right, right.left, level + 1);
    }

    /****************** Approach 2 ************/
    public TreeNode reverseOddLevelsInPlace(TreeNode root) {
        Map<Integer, List<TreeNode>> levelMapOfNodes = new HashMap<>();
        fillMap(root, levelMapOfNodes, 0);

        for(int level : levelMapOfNodes.keySet()){
            if(levelMapOfNodes.containsKey(level + 1)){
                if(level % 2 == 0){
                    mapChildren(levelMapOfNodes.get(level), levelMapOfNodes.get(level+1), true);
                }else{
                    mapChildren(levelMapOfNodes.get(level), levelMapOfNodes.get(level+1), false);
                }
            }
        }
        return root;
    }

    public void fillMap(TreeNode node, Map<Integer,List<TreeNode>> levelMapOfNodes, int level){
        if(node == null)
            return;

        if(!levelMapOfNodes.containsKey(level))
            levelMapOfNodes.put(level, new ArrayList<TreeNode>());

        levelMapOfNodes.get(level).add(node);
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null ; node.right = null;

        fillMap(left,levelMapOfNodes, level + 1);
        fillMap(right,levelMapOfNodes, level + 1);
    }

    public void mapChildren(List<TreeNode> parentList, List<TreeNode> childrenList, boolean reverse){
        if(reverse){
            int parent = 0;
            int child = childrenList.size() - 1;
            while(parent < parentList.size() && child >= 0){
                parentList.get(parent).left = childrenList.get(child--);
                parentList.get(parent++).right = childrenList.get(child--);
            }
        }else{
            int parent = parentList.size() - 1;
            int child = 0;
            while(parent >= 0 && child < childrenList.size()){
                parentList.get(parent).left = childrenList.get(child++);
                parentList.get(parent--).right = childrenList.get(child++);
            }
        }
    }
}
