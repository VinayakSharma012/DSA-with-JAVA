package ArrayandStrings;
public class StairCaseSearch {
    public static boolean staircase(int arr1[][],int key) {
        int row =0; int col= arr1[0].length-1;
        while(row < arr1.length && col >=0) {
            if(arr1[row][col] == key) {
                System.out.println("found key at : "+row+" , "+col);
                return true;
            }
            else if(key < arr1[row][col]) {
                col--;
            }
            else {
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }
    public static void main(String args[]) {
        int matrix[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        StairCaseSearch obj = new StairCaseSearch();
        obj.staircase(matrix,27);
    }
}
