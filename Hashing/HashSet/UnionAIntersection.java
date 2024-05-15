package Hashing.HashSet;
import java.util.*;
public class UnionAIntersection {
    public static void Union(int arr1[],int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++) {
            set.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union = "+set.size()+" "+set);
    }
    public static void Intersection(int arr1[],int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<arr1.length;i++) {
            set.add(arr1[i]);
        }

        int count = 0;

        for(int i=0;i<arr2.length;i++) {
            if(set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
                set2.add(arr2[i]);
            }
        }

        System.out.println("Intersection = "+count+" "+set2);
    }
    public static void main(String args[]) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        Union(arr1, arr2);
        Intersection(arr1, arr2);
    }
}
