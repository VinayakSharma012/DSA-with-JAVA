package DynamicProgramming;

import java.util.Arrays;
public class CatalansNumber {
    //using recursion
    public static int catalan(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            ans += catalan(i)*catalan(n-i-1);
        }

        return ans;
    }
    //using tabulation
    public static int catalanMem(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            ans += catalanMem(i,dp)*catalanMem(n-i-1,dp);
        }

        dp[n] = ans;
        return dp[n];
    }
    //using tabulation
    public static int catalanTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++) {
            for(int j=0; j<i;j++) {
            dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String args[]) {
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMem(n,dp));
        System.out.println(catalanTab(n));
    }
}
