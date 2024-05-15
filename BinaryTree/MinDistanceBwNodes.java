package BinaryTree;

public class MinDistanceBwNodes {
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
    public static Node LCA2(Node root,int n1,int n2) {
        //base case
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = LCA2(root.left, n1, n2);
        Node rightLCA = LCA2(root.right, n1, n2);

        //leftLCA = value where rightLCA == null
        if(rightLCA == null) {
            return leftLCA;
        }
        //rightLCA = value where leftLCA == null
        if(leftLCA == null) {
            return rightLCA;
        }

        //both are not null
        return root;
    }
    public static int lcaDistance(Node root,int n) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }

        int leftD = lcaDistance(root.left, n);
        int rightD = lcaDistance(root.right, n);

        if(leftD == -1 && rightD == -1) {
            return -1;
        }
        else if(leftD == -1) {
            return rightD+1;
        }
        else {
            return leftD+1;
        }
    }
    public static int minDistance(Node root,int n1,int n2) {
        Node lca = LCA2(root, n1, n2);
        int dis1 = lcaDistance(lca,n1);
        int dis2 = lcaDistance(lca,n2);
        return dis1 + dis2;
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("min distance bw two nodes is = "+minDistance(root, 4, 6));
    }
}
