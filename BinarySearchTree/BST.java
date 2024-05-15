package BinarySearchTree;

import java.util.ArrayList;

public class BST {
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
    public static Node Insert(Node root, int val) { 
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            //left subtreee
           root.left = Insert(root.left, val);
        } else {
            //right subtree
            root.right = Insert(root.right, val);
        }
        return root;
    }
    public static void InOrder(Node root) {
        if(root == null) {
            //System.out.print(-1+" "); 
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }
    public static boolean search(Node root,int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        else if(root.data > key) {
            return search(root.left, key);
        } 
        else {
            return search(root.right, key);
        }
    }
    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        } else {//voila
            //case 1 leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            //case 2 single child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            //case 3 both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void PrintInRange(Node root ,int k1,int k2) {
        if(root == null) {
            return;
        }

        if(root.data >= k1 && root.data <= k2) {
            PrintInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            PrintInRange(root.right, k1, k2);
        } else if(root.data < k1) {
            PrintInRange(root.left, k1, k2);
        } else {
            PrintInRange(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0;i<path.size();i++) {
            System.out.print(path.get(i)+" -> ");
        }
        System.out.println("null");
    }
    public static void printRootTOLeaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
             return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        printRootTOLeaf(root.left, path);
        printRootTOLeaf(root.right, path);
        path.remove(path.size()-1);
    } 
    public static boolean isValidBST(Node root,Node min,Node max) {
        if(root == null) {
            return true;
        }
        //right
        if(min != null && root.data <= min.data) {
            return false;
        }
        //left
        else if(max != null && root.data >= max.data) {
             return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static Node MirrorBST(Node root) {
        if(root == null) {
            return null;
        }
        Node lefts = MirrorBST(root.left);
        Node rights = MirrorBST(root.right);
        root.left = rights;
        root.right = lefts;
        return root;
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
    public static void main(String args[]) {
        int BST[] = {8,5,3,6,10,11};
        Node root = null;
        for(int i=0;i<BST.length;i++) {
            root = Insert(root,BST[i]);
        }
        InOrder(root);
        System.out.println();
        System.out.println(search(root,6));
        
        InOrder(root);
        System.out.println();
        PrintInRange(root, 5, 12);
        System.out.println();
        printRootTOLeaf(root, new ArrayList<>());
        System.out.println(isValidBST(root, null,null));
        MirrorBST(root);
        PreOrder(root);
        
    }
}
