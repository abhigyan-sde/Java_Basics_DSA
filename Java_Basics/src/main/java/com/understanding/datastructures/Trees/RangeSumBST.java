package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

public class RangeSumBST {

    /*
     938. Range Sum of BST

     We solve this problem using a recursive approach. Given a Binary Search Tree the follow property holds true for any node in
      the tree. Property : Every node is greater than the maximum value in it's left subtree and smaller than the minimum
      value in it's right subtree. We use this property to decide which direction to explore in the tree and collect the values
      for the range Sum.
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;

        int sum = 0;
        /*
            If the node's value is greater than the range then we need to explore leftSubtree because any value in the right
            subtree will still be outside the range and > high.
         */

        if(root.val > high)
            sum += rangeSumBST(root.left, low, high);
        /*
             If the node's value is less than the range then we need to explore rightSubtree because any value in the left
            subtree will still be outside the range and < low.
         */
        else if(root.val < low)
            sum += rangeSumBST(root.right, low, high);
        /*
            This is the point when we are at a value which lies in the range and we want to explore both the subtrees to get
            the sum.
         */
        else{
            sum += root.val;
            sum += rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
