package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

public class LCAInBT {
    /*
        236. Lowest Common Ancestor of a Binary Tree.
        1644. LCA of a BinaryTree II
        We have the following possible cases for finding the ancestor for p & q :
        1) P & Q lie on the other sides of subtree rooted at node. Then node is our answer.
        2) p & Q lie on the same side of the subtree rooted at nodeR, then whichever node (P or Q) is closer to nodeR is the ancestor.
        We have used a Result class to encapsulate the two fields required to determine the ancestor for our recursive function.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = helper(root,p,q);
        return result.isAncestor ? result.node : null;
    }

    private Result helper(TreeNode node, TreeNode p, TreeNode q){
        //This is a null node so return the result with null node and false indicating ancestor not found.
        if(node == null)
            return new Result(false, null);

        //Recursive call on the left subtree --> If ancestor is found in left subtree return the result from here.
        Result left = helper(node.left,p,q);
        if(left.isAncestor)
            return left;

        //Recursive call on the right subtree --> If ancestor is found in right subtree return the result from here.
        Result right = helper(node.right,p,q);
        if(right.isAncestor)
            return right;

        //If ancestor is not yet found and P and Q have been found in the left and right subtrees then return this node as the ancestor.
        if(left.node != null && right.node != null){
            return new Result(true,node);
        }

        //If this node equals to either P or Q then determine if this is an ancestor based on either of left or right node is not null.
        if(node == p || node == q){
            boolean ancestor = (left.node != null || right.node != null);
            return new Result(ancestor,node);
        }
        //We have not found the ancestor yet, pass the node back up depending on left.node or right.node not being null.
        else{
            return new Result(false, left.node == null ? right.node : left.node);
        }
    }

    private class Result{
        boolean isAncestor;
        TreeNode node;
        public Result(boolean ancestor, TreeNode node){
            this.isAncestor = ancestor;
            this.node = node;
        }
    }
}
