package DynamicProgramming;
import java.util.*;
public class RodCutting {
    //tabulation
    public static int rodCutting(int price[], int length[], int RodLength) {
        int n = price.length;
        int dp[][] = new int[n+1][RodLength+1];
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++) {
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<RodLength+1;j++) {
                int v = price[i-1];
                int w = length[i-1];
                if(w <= j) { //valid
                    int incProfit = v + dp[i][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][RodLength];
    }
    public static void main(String args[]) {
        int price[] = {1,5,8,9,10,17,17,20};
        int length[] = {1,2,3,4,5,6,7,8};
        int RodLength = 8;

        System.out.println(rodCutting(price,length,RodLength));
    }
}

