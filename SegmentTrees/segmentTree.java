package SegmentTrees;

public class segmentTree {
    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int i, int start, int end) {
        if(start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start+end)/2;
        buildST(arr, 2*i+1, start, mid); //left subtree
        buildST(arr, 2*i+2, mid+1, end); //right subtree

        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSumutil(int i, int si, int sj, int qi, int qj) {
        //non overlapping condiition
        if(qj < si || qi > sj) {
            return 0;
        } else if(si >= qi && sj <= qj) { //overlapping condition
            return tree[i];
        } else {
            //partial overlapping condition
            int mid = (si+sj)/2;
            int left = getSumutil(2*i+1, si, mid, qi, qj);
            int right = getSumutil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumutil(0, 0, n-1, qi, qj);
    }
    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if(idx > sj || idx < si) { //idx doesnt lie in range
            return;
        }

        tree[i] += diff;

        if(si != sj) { //non leaf condition
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff); //left
            updateUtil(2*i+2, mid+1, sj, idx, diff); //right
        }
    }
    public static void updatek(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0, 0, n-1, idx, diff); //sgement tree updation
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0;i<tree.length;i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getSum(arr, 2, 5));
        updatek(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));
    }
}
