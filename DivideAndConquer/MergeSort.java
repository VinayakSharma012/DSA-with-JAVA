package DivideAndConquer;

public class MergeSort {

    public static void printArr(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void Merge(int arr[], int si,int ei) {
        //base case
        if(si >= ei) {
            return;
        }
        //kaam
        int mid = si + (ei-si)/2;
        Merge(arr,si,mid);
        Merge(arr,mid+1,ei);
        Merging(arr,si,mid,ei);
    }
    public static void Merging(int arr[],int si,int mid,int ei) {
        int temp[] = new int[ei-si+1];
        //left(0,3)=4 right(4,6)=3 --> 6-0 = 6 +1 =7
        int i = si; //iterator for left
        int j = mid+1; //iterator for right part
        int k = 0; //iterator temporary array
        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //left part
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        //right part
        while(j <= ei) {
            temp[k++] = arr[j++];
        }
        //copy temp arr to original array
        for(k=0,i=si;k<temp.length;k++,i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String args[]) {
        int arr[] = {6,3,9,5,2,-4,8};
        int n = arr.length;
        Merge(arr,0,n-1);
        printArr(arr);
    }
}
