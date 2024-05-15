package Trie;

public class Trie {
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

    public static boolean Search(String key) {
        Node curr = root;
        for(int level = 0; level < key.length();level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow = true;
    }
    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for(int i=0;i<words.length;i++) {
            Insert(words[i]);
        }

        String key1 = "thee";
        String key2 = "thor";
        System.out.println(Search(key1));
        System.out.println(Search(key2));
    }
}
