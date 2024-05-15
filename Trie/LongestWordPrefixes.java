package Trie;

public class LongestWordPrefixes {
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
    public static String ans = " ";
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0;i<26;i++) { //revrse loop for print apply which is lexicographically larger than apply
            if(root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp); // recursiomn
                temp.deleteCharAt(temp.length()-1); //backtarcking
            } 
        }
    }
    public static void main(String args[]) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(int i=0;i<words.length;i++) {
            Insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans); //lexicographically small element comes first apple > apply
    }
}
