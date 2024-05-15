package Trie;

public class CountUniqueSubstring {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0;i<children.length;i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void Insert(String words) {
        Node curr = root;
        for(int level = 0; level < words.length();level++) {
            int idx = words.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } 
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0;i<26;i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }
    public static void main(String args[]) {
        String str = "ababa";

        //suffixes -> insert into trie
        for(int i=0;i<str.length();i++) {
            String suffix = str.substring(i);
            Insert(suffix);
        }

        System.out.println(countNodes(root));
    }
}
