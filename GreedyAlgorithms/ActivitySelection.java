package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class ActivitySelection {
    public static void main(String args[]) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};


        //if end time is not sorted
        int activites[][] = new int[start.length][3]; // index,start,end coll
        for(int i=0;i<start.length;i++) {
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }
        //lambda function is used
        Arrays.sort(activites,Comparator.comparingDouble(o -> o[2]));


        //end time basis sort
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAct = 1;
        ans.add(activites[0][0]);
        int lastEnd = activites[0][2];
        for(int i=0;i<end.length;i++) {
            if(activites[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activites[i][0]);
                lastEnd = activites[i][2];
            }
        }

        System.out.println("maximum activites = "+ maxAct);

        for(int i=0;i<ans.size();i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}
