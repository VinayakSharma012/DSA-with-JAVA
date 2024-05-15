public class Occurence {
    public static int FirstOC(int arr[],int key,int i) {
        if(arr[i] == key) {
            return i;
        }
        if(i == arr.length) {
            return -1;
        }
        return FirstOC(arr,key, i+1);
    }
    public static int LastOC(int arr[],int key,int i) {
        if(i == arr.length) {
            return -1;
        }
        int isFound = LastOC(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }
    public static void main(String args[]) {
        int arr[] = {8,3,6,9,5,10,2,5,3};
        System.out.println(FirstOC(arr,5, 0));
        System.out.println(LastOC(arr,5, 0));
    }
}
