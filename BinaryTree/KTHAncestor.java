package BinaryTree;

public class KTHAncestor {
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
    public static int KAncestor(Node root,int n,int k) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }

        int leftD = KAncestor(root.left, n, k);
        int rightD = KAncestor(root.right,n,k);

        if(leftD == -1 && rightD == -1) {
            return -1;
        }

        int max = Math.max(leftD, rightD);
        if(max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n = 4; int k =1;
        KAncestor(root, n, k);
    }

}
