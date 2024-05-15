package Trie;

public class startsWithProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0;i<26;i++) {
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

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for(int level = 0; level < prefix.length();level++) {
            int idx = prefix.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow = true;
    }

    public static void main(String args[]) {
        String words[] = {"apple", "app", "mango", "mango", "man", "woman"};

        for(int i=0;i<words.length;i++) {
            Insert(words[i]);
        }
        System.out.println(startsWith("app"));
    }
}
