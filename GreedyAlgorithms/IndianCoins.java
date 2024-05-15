package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String args[]) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int val = 5463;
        int count = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(coins,Comparator.reverseOrder());
        for(int i = 0;i<coins.length;i++) {
            if(val >= coins[i]) {
                while(coins[i] <= val) {
                count++;
                ans.add(coins[i]);
                val -= coins[i];
            }
        }
        }
        System.out.println("total coins = "+count);

        for(int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
