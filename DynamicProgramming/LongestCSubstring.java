package DynamicProgramming;

public class LongestCSubstring {
    public static void LSubstring(String str1, String str2) { 
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=0;i<n+1;i++) {
            for(int j=0;j<m+1;j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String args[]) {
        String str1 = "ABCDGH";
        String str2 = "ACDGHR";
        LSubstring(str1, str2);
    }
}

