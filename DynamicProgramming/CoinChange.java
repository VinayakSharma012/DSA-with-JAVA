package DynamicProgramming;

public class CoinChange {
    public static void coinChange(int coins[], int Sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][Sum+1];
        //i = items j = targetsum
        for(int i=0;i<n+1;i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<Sum+1;j++) {
                int v = coins[i-1];
                if(v <= j) { //valid
                    dp[i][j] = dp[i][j-v] + dp[i-1][j];
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        System.out.println(dp[n][Sum]);
    }
    
    public static void main(String args[]) {
        int coins[] = {2,5,3,6};
        int Sum = 10;

        coinChange(coins, Sum);
    }
}
