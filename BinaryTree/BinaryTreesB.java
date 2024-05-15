package BinaryTree;

import java.util.*;

public class BinaryTreesB {
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

    static class BinaryTree {
        static int idx = -1;
        public static Node Buildtree(int nodes[]) { //root will return from here
            idx++;
            if(nodes[idx] == -1) {
                return null;
            } 
            Node newNode = new Node(nodes[idx]);
            newNode.left = Buildtree(nodes);
            newNode.right = Buildtree(nodes);

            return newNode;
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
        public static void InOrder(Node root) {
            if(root == null) {
                //System.out.print(-1+" "); 
                return;
            }
            InOrder(root.left);
            System.out.print(root.data+" ");
            InOrder(root.right);
        }
        public static void PostOrder(Node root) {
            if(root == null) {
                //System.out.print(-1+" "); 
                return;
            }
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data+" ");
        }
        public static void LevelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            if(root == null) {
                return;
            }
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    } 
                    if(currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int Height(Node root) {
            if(root == null) { 
                return 0;
            }
            int lh = Height(root.left);
            int rh = Height(root.right);
            int height = Math.max(lh, rh)+1;
            return height;
        }
        public static int Count(Node root) {
            if(root == null) { 
                return 0;
            }
            int Lcount = Count(root.left);
            int Rcount = Count(root.right);
            int count = Lcount+Rcount+1;
            return count;
        }
        public static int Sum(Node root) {
            if(root == null) { 
                return 0;
            }
            int Lsum = Sum(root.left);
            int Rsum = Sum(root.right);
            int sum = Lsum+Rsum+root.data;
            return sum;
        }
        public static int Diameter(Node root) { // O(n2) complexity not optimised 
            if(root == null) { 
                return 0;
            }
            int LD = Diameter(root.left);
            int RD = Diameter(root.right);
            int RootDiameter = Height(root.left) + Height(root.right) + 1;
            int Diameter = Math.max(RootDiameter,Math.max(LD, RD));
            return Diameter;
        }
    }
    public static void main(String args[]) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.Buildtree(nodes);
        System.out.println(root.data);
        tree.PreOrder(root);
        System.out.println();
        tree.InOrder(root);
        System.out.println();
        tree.PostOrder(root);
        System.out.println();
        tree.LevelOrder(root);
        System.out.print("height of tree = "+tree.Height(root));
        System.out.println();
        System.out.print("total count of nodes in tree = "+tree.Count(root));
        System.out.println();
        System.out.print("sum of nodes of a tree = "+tree.Sum(root));
        System.out.println();
        System.out.print("diameter of a tree = "+tree.Diameter(root));
    }
    }

