package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

public class MergeTrees {
    /*
    617. Merge Binary Trees

    In this problem we take a recursive approach. Let's talk about the possible cases we can have while exploring nodes in respective
    binary trees. We will use node1 to denote node in Tree1 and node2 to denote node in Tree2.
    If node1 and node2 both are not null then add their values.
    If either of them is null then return the one which is not null else if both are null return null.
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        /*
        Base case for recursion
         */
        if(root1 == null || root2 == null)
            return root1 == null ? root2 : root1;

        //Recurse over left and right for both trees
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);

        //Perform node merger
        root1.val += root2.val;
        root1.left = left;
        root1.right = right;
        return root1;
    }
}
