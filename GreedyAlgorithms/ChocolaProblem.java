package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ChocolaProblem {
    public static void main(String args[]) {
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};
        int hp =1,vp=1,h=0,v=0,cost=0;;

        Arrays.sort(costVer,Comparator.reverseOrder());
        Arrays.sort(costHor,Comparator.reverseOrder());
        
        while(h < costHor.length && v < costVer.length) {
            //vertical cost < hor cost
            if(costVer[v] <= costHor[h]) { //horizontal cost
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            else {
                //vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while(h < costHor.length) {
            cost += (costHor[h] * vp);
                hp++;
                h++;
        }

        while(v < costVer.length) {
            cost += (costVer[v] * hp);
                vp++;
                v++;
        }
        System.out.println(" minimum cost of cuts = "+cost);
    }
}
