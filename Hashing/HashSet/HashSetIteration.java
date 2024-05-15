package Hashing.HashSet;
import java.util.*;
public class HashSetIteration {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(5);
        set.add(3);

        //using Iterator Interface
        Iterator it = set.iterator(); //interface

        while(it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        //using For each loop

        for (Integer i : set) {
            System.out.print(i+" ");
        }
    }
}
