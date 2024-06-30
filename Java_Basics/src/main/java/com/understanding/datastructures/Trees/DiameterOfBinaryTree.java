package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

public class DiameterOfBinaryTree {
    /*
    543. Diameter Of Binary Tree
    Diameter of binary tree can either exist in the Left SubTree or in Right SubTree
    or pass through the root of the tree.
    */
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterFinder(root);
        return diameter;
    }
    public int diameterFinder(TreeNode root){
        if(root == null)
            return 0;

        int leftHeight = diameterFinder(root.left);
        int rightHeight = diameterFinder(root.right);

        //Take the max between existing diameter value
        // and the path length going through the currentNode.
        diameter = Math.max(diameter, leftHeight + rightHeight);

        //Return the maximum height + 1 to the recursive call.
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
