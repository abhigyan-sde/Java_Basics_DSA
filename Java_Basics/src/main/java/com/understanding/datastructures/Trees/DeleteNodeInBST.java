package Java_Basics.src.main.java.com.understanding.datastructures.Trees;

public class DeleteNodeInBST {
    /*
        450. Delete Node in a BST
     */
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null)
            return null;

        if(root.val < key){
            //search in right subtree
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            //search in leftSubtree
            root.left = deleteNode(root.left,  key);
        }else{
            //We have found the node with key
            //Case 1 : Leaf Node
            if(root.left == null && root.right == null){
                root = null;
            }
            //Case 2 : The node has a right child, We replace the value of node with it's successor.
            else if(root.right != null){
                root.val = findSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }
            //Case 3 : The node has a left child, We replace the value of node with it's predecessor.
            else{
                root.val = findPredecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int findSuccessor(TreeNode node){
        node = node.right;
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }

    private int findPredecessor(TreeNode node){
        node = node.left;
        while(node.right != null){
            node = node.right;
        }
        return node.val;
    }
}
