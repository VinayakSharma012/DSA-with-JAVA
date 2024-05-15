package BinaryTree;

public class DiameterOfTree {
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
    static class info { // O(n) optimised 
            int diam,ht;
            public info(int diam,int ht) {
                this.diam = diam;
                this.ht = ht;
            }
    }
    public static info diameter(Node root) {
        if(root == null) {
            return new info(0, 0);
        }
        info leftInfo = diameter(root.left);
        info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;
        return new info(diam, ht);
        }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("diameter of a tree = "+diameter(root).diam);

    }

}
