package Hashing.HashSet;
import java.util.*;
public class SubArraySumToK {
    public static void main(String args[]) {
        int arr[] = {10,2,-2,-20,10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int j = 0; j < arr.length;j++) {
            sum += arr[j]; //sum
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            } 
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.print("ans = "+ans);
    }
}
