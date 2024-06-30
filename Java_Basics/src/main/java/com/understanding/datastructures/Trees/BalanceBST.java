package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    /*
       1382 : Balance a Binary Search Tree
       In this solution I have done an inOrderTraversal over the BST and stored the TreeNodes accordingly in a List.
       Then use recursion to build the BST from the inOrderList containing the TreeNodes.
       The Inorder traversal will give us a List of TreeNodes which will be sorted according to their value.
       So we know in the array all the elements to the left of mid will be less than inOrderList[mid] value and on the right it will be greater.
     */
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inOrderNodeList = new ArrayList<>();
        getNodesInOrder(root, inOrderNodeList);
        return buildBalancedTree(inOrderNodeList, 0, inOrderNodeList.size() - 1);
    }

    private void getNodesInOrder(TreeNode root, List<TreeNode> inOrderNodeList){
        if(root == null)
            return;

        getNodesInOrder(root.left, inOrderNodeList);
        inOrderNodeList.add(root);
        getNodesInOrder(root.right, inOrderNodeList);
    }

    private TreeNode buildBalancedTree(List<TreeNode> inOrderNodeList, int start, int end){
        if(start > end)
            return null;

        int mid = start + (end-start)/2;
        TreeNode root = inOrderNodeList.get(mid);
        root.left = buildBalancedTree(inOrderNodeList, start, mid - 1);
        root.right = buildBalancedTree(inOrderNodeList, mid + 1, end);
        return root;
    }
}
