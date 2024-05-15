package DynamicProgramming;

public class MinimumPartition {
    public static int minPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;

        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
        }
        int W = sum/2;

        int dp[][] = new int[n+1][W+1];
        //auto initalise 0                                                                                                                                                                                                                                                                                                                                            
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<W+1;j++) {
                int v = arr[i-1];
                int w = arr[i-1];
                if(w <= j) { //valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }
    public static void main(String args[]) {
        int arr[] = {1,6,11,5};
        
        System.out.println(minPartition(arr));
    }
}
