package Linkedlist;
import java.util.LinkedList;
public class LLinJavaCollection {
    public static void main(String args[]) {
        //create 
        LinkedList<Integer> ll = new LinkedList<>();
        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        System.out.println(ll);
        //remove
        System.out.println(ll.removeLast());
        System.out.println(ll.removeFirst());
        System.out.println(ll);
    }
}
