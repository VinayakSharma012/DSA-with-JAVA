package BinarySearchTree;

import java.util.ArrayList;

public class BSTtoBalancedBST {
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
    public static Node CreateBST(ArrayList<Integer> arr,int st,int end) {
        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = CreateBST(arr, st, mid-1);
        root.right = CreateBST(arr, mid+1, end);
        return root;
    }
    public static void InOrderBST(Node root,ArrayList<Integer> arr) {
        if(root == null) {
            //System.out.print(-1+" "); 
            return;
        }
        InOrderBST(root.left,arr);
        arr.add(root.data);
        InOrderBST(root.right,arr);
    }
    public static void PreOrder(Node root) {
        if(root == null) {
            //System.out.print(-1+" "); 
            return;
        }
        System.out.print(root.data+" ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public static Node balancedBST(Node root) {
        //inorder seq
        ArrayList<Integer> arr = new ArrayList<>();
        InOrderBST(root,arr);

        //create bst
        return CreateBST(arr, 0, arr.size()-1);
    }
    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        root = balancedBST(root);
        System.out.println();
        PreOrder(root);
    }
}
