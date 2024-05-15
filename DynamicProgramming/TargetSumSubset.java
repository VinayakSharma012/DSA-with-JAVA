package DynamicProgramming;

public class TargetSumSubset {
    public static boolean targetSum(int numbers[], int TargetSum) {
        int n = numbers.length;
        boolean dp[][] = new boolean[n+1][TargetSum+1];
        //i = items j = targetsum
        for(int i=0;i<n+1;i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<TargetSum+1;j++) {
                int v = numbers[i-1];
                if(v <= j && dp[i-1][j-v] == true) {
                    //include
                    dp[i][j] = true;
                } else if(dp[i-1][j] == true) {
                    //exclude
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][TargetSum];
    }
    public static void print(boolean dp[][]) {
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) { 
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int numbers[] = {4,2,7,1,3};
        int TargetSum = 10;

        System.out.println(targetSum(numbers, TargetSum));
    }
}
