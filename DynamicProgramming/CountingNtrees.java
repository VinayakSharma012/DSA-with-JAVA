package DynamicProgramming;

public class CountingNtrees {
    public static int countTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++) {
            for(int j=0; j<i;j++) {
                int leftSubtree = dp[j];
                int rightSubtree = dp[i-j-1];
                dp[i] += leftSubtree * rightSubtree;
            }
        }
        return dp[n];
    }    
    public static void main(String args[]) {
        int n = 4;
        System.out.println(countTrees(n));
    }
}
