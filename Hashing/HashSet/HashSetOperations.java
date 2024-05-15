package Hashing.HashSet;
import java.util.*;
public class HashSetOperations {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        //add
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);
        System.out.println(set);
        //contains
        System.out.println(set.contains(4));

        //remove
        System.out.println(set.remove(4));
        System.out.println(set);

        //size
        System.out.println(set.size());

        //clear
        set.clear();
        System.out.println(set);

        //empty
        System.out.println(set.isEmpty());
    }
}
