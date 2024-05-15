package ArrayandStrings;
public class DiagonalMatrix {
    //brute force method
    public static int DiagonalM(int arr1[][]) {
        int sum =0;
        // for primary diagonal
        for(int i=0;i<arr1.length;i++) {
            for(int j=0;j<=arr1[0].length;j++) {
                if(i==j) {
                    sum += arr1[i][j];
                }
                else if(i+j == arr1.length-1) {
                    sum += arr1[i][j];
                }
            }
        }
        return sum;
    }
    // linear complexity
    public static int DiagonalOptimised(int arr1[][]) {
        int sum =0;
        for(int i=0;i<arr1.length;i++) {
            // for primary diagonal
            sum += arr1[i][i];
            // for secondary diagonal
            if(i != arr1[i][arr1.length-i-1])
            sum+= arr1[i][arr1.length-i-1];
        }
        return sum;
    }

    public static void main(String args[]) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        DiagonalMatrix obj = new DiagonalMatrix();
        int s = obj.DiagonalOptimised(matrix);
        System.out.println("sum of diagonal is : "+s);
    }
}
