package BackTracking;

public class GridWays {
    public static int nGridWays(int i,int j,int m,int n) {
        //base case
        if(i == m-1 && i == n-1) { //last cell cond
            return 1;
        } 
        else if(i == n || j == n) { //boudary cross
            return 0;
        }
        //kaam
        int w1 = nGridWays(i+1, j, m, n);
        int w2 = nGridWays(i, j+1, m, n);
        return w1+w2;
    }
    
    public static void main(String args[]) {
        int n = 3,m = 3;
        System.out.println(" total number of ways : " + nGridWays(0, 0, m, n));//total number of ways
    }
}
