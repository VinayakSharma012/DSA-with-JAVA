package Hashing.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
public class HashMapOperations {
    public static void main(String args[]) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();
        //insert
        hm.put("India",100);
        hm.put("China", 150);
        hm.put("US",50);

        System.out.println(hm);

        //get 
        System.out.println(hm.get("India"));

        //contains key
        System.out.println(hm.containsKey("India"));

        //remove key
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //is empty
        System.out.println(hm.isEmpty());

        //clear
        hm.clear();
        System.out.println(hm);
    }
}
