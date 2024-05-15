package BinaryTree;

public class SubTreeOFAnotherTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isIdentical(Node node,Node subroot) {
        if(node == null && subroot == null) {
            return true;
        } else if(node == null || subroot == null || node.data != subroot.data) {
            return false;
        }

        if(!isIdentical(node.left, subroot.left)) { //left  part
            return false;
        }
        if(!isIdentical(node.right, subroot.right)) { //right part
            return false;
        }

        return true;
    }
    public static boolean isSubTree(Node root,Node subroot) {
        if(root == null) {
            return false;
        }
        if(root.data == subroot.data) {
            if(isIdentical(root,subroot)) {
                return true;
            }
        }

        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }
    public static void main(String args[])  {
        //tree
        /*  1
          /   \
        2       3
      /  \       \
    4     5       6
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        //subtree
        /*  
          2 
         /  \  
        4    5  
         */
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println(isSubTree(root, subroot));
    }
}

