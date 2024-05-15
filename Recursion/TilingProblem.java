public class TilingProblem {
    public static int tiling(int n)  {
        if(n ==0 || n == 1) {
            return 1;
        }
        //kaam
        //vertical choice
        int verticalTiles = tiling(n-1);

        //horizntal tiles
        int horizntalTiles = tiling(n-2);

        int totalWays = verticalTiles + horizntalTiles;
        return totalWays;
    } 
    public static void main(String args[]) {
        System.out.println(tiling(4));
    }
}
