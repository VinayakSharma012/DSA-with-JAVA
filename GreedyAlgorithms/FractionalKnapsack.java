package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String args[]) {
        int weight[] = {10,20,30};
        int value[] = {60,100,120};
        int finalvalue = 0;
        int capacity = 50;

        double ratio[][] = new double[value.length][2];
        //0th col => idx; 1st col => ratio

        for(int i=0;i<value.length;i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }
        //ascending order sort
        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));

        for(int i = ratio.length-1;i>=0;i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) { //include full item
                finalvalue += value[idx];
                capacity -= weight[idx];
            } else {
                //include fractional item
                finalvalue += ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }

        System.out.println("total weight = "+ finalvalue);
    }
}
