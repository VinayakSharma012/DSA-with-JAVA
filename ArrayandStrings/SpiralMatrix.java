package ArrayandStrings;
public class SpiralMatrix {
    public static void PrintSpiral(int arr[][]) {
        int startrow=0;
        int endrow= arr.length-1;
        int startcol=0;
        int endcol=arr[0].length-1;

        while(startrow <= endrow && startcol <= endcol) {
            //top
            for(int j=startcol;j<=endcol;j++) {
                System.out.print(arr[startrow][j]+" ");
            }
            //right
            for(int i=startrow+1;i<=endrow;i++){
                System.out.print(arr[i][endcol]+" ");
            }
            //bottom
            for(int j=endcol-1; j>= startcol;j--) {
                if(startrow == endrow){
                    break;
                }
                System.out.print(arr[endrow][j]+" ");
            }
            //left
            for(int i=endrow-1;i>=startrow+1;i--) {
                if(startcol == endcol){
                    break;
                }
                System.out.print(arr[i][startcol]+" ");
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
    }
    public static int Diagonal(int arr1[][]) {
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
    public static void main(String args[]) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        SpiralMatrix obj = new SpiralMatrix();
        obj.PrintSpiral(matrix);
        int p = obj.Diagonal(matrix);
        System.out.println(" sum is : "+p);

    }
}
