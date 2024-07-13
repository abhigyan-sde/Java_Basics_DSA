package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

public class LCAInBST {
    /*
     235. Lowest Common Ancestor of a BinarySearchTree
     In a BST if we are finding the common ancestor for node p and node q, we need to think about the
     possible cases we can arrive at while searching for the ancestor.
     1) If The node q and node p are on the other side of the root, in that case root of the subtree is the ancestor.
     2) If p and q are in the same subtree and whichever has been encountered first becomes the ancestor.
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root == p || root == q)
                return root;

            if(root.val > p.val && root.val > q.val){
                //Move the search to left subtree
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                //Move the search to right subtree
                root = root.right;
            }else{
                //Root of this subtree is the ancestor we are looking for.
                return root;
            }
        }
        return null;
    }
}
