package BinaryTree;
import java.util.*;

public class TopViewOFTree {
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
    static class info {
        Node node;
        int hd;

        public info(Node node,int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
        public static void TopViewtree(Node root) {
            //level order
            Queue<info> q = new LinkedList<>();
            int min = 0;
            int max = 0;
            HashMap<Integer,Node> map = new HashMap<>();
            q.add(new info(root, 0));
            q.add(null);

            while(!q.isEmpty()) {
                info curr = q.remove();

                if(curr == null) {
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {

                if(!map.containsKey(curr.hd)) { //first time my hd is occurring
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null) {
                    q.add(new info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                if(curr.node.right != null) {
                    q.add(new info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
            for(int i = min;i<=max;i++) {
                System.out.print(map.get(i).data+" ");
            }
        }
        public static void main(String args[]) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.right = new Node(4);
            root.left.right.right = new Node(5);
            root.left.right.right.right = new Node(6);
            TopViewtree(root);
        }
}
