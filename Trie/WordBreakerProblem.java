package Trie;

public class WordBreakerProblem {
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

    public static boolean WordBreak(String key) {
        //base case
        if(key.length() == 0) {
            return true;
        }
        for(int i=1;i<=key.length();i++) {
            //substring(beg idx to last idx);
            if(Search(key.substring(0, i)) && WordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        for(int i=0;i<words.length;i++) {
            Insert(words[i]);
        }

        System.out.println(WordBreak("ilikesamsung"));
        
    }
}
