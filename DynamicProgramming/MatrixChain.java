package DynamicProgramming;

import java.util.Arrays;

public class MatrixChain {
    //using recusrion
    public static int matrixChainMul(int arr[], int i, int j) {
        if(i == j) {
            return 0; //single matrix
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1;k++) {
            int cost1 = matrixChainMul(arr, i, k); // Ai....Ak => arr[i-1] * arr[k]
            int cost2 = matrixChainMul(arr, k+1, j); // Ak+1....Aj => arr[k] * arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }

        return ans;
    }
    //using memoization
    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        if(i == j) {
            return 0; //single matrix
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1;k++) {
            int cost1 = mcmMemo(arr, i, k, dp); // Ai....Ak => arr[i-1] * arr[k]
            int cost2 = mcmMemo(arr, k+1, j, dp); // Ak+1....Aj => arr[k] * arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    //using tabulation
    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        //initialisation
        for(int i=0;i<n;i++) {
            dp[i][i] = 0;
        }
        //bottom up
        for(int len=2;len<=n-1;len++) {
            for(int i=1;i<=n-len;i++) {
                int j = i+len-1; // col
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<=j-1;k++) {
                    int cost1 = dp[i][k]; // Ai....Ak => arr[i-1] * arr[k]
                    int cost2 = dp[k+1][j]; // Ak+1....Aj => arr[k] * arr[j]
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        int i = 1;
        int j = n-1;
        int dp[][] = new int[n][n];
        for(int p=0;p<n;p++) {
            Arrays.fill(dp[p], -1);
        }
        System.out.println(matrixChainMul(arr, i, j));
        System.out.println(mcmMemo(arr, i, j, dp));
        System.out.println(mcmTab(arr));
    }
}
