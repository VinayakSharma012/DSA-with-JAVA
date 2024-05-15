package SegmentTrees;

public class MinSegmentTree {
    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int i, int start, int end) {
        if(start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = start+(end-start)/2;
        buildST(arr, 2*i+1, start, mid); //left subtree
        buildST(arr, 2*i+2, mid+1, end); //right subtree

        tree[i] = Math.min(tree[2*i+1], tree[2*i+2]);
        return tree[i];
    }

    public static int getMinutil(int i, int si, int sj, int qi, int qj) {
        //non overlapping condiition
        if(qj < si || qi > sj) {
            return Integer.MAX_VALUE;
        } else if(si >= qi && sj <= qj) { //overlapping condition
            return tree[i];
        } else {
            //partial overlapping condition
            int mid = (si+sj)/2;
            int left = getMinutil(2*i+1, si, mid, qi, qj);
            int right = getMinutil(2*i+2, mid+1, sj, qi, qj);
            return Math.min(left, right);
        }
    }
    public static int getMin(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMinutil(0, 0, n-1, qi, qj);
    }
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if(idx > sj || idx < si) { //idx doesnt lie in range
            return;
        }

        if(si == sj) {
            tree[i] = newVal;
        }

        if(si != sj) { //non leaf condition
            tree[i] = Math.min(tree[i], newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal); //left
            updateUtil(2*i+2, mid+1, sj, idx, newVal); //right
        }
    }
    public static void update(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;

        updateUtil(0, 0, n-1, idx, newVal); //sgement tree updation
    }
    public static void main(String args[]) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0;i<tree.length;i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getMin(arr, 2, 5));
        update(arr, 2, 20);
        System.out.println(getMin(arr, 2, 5));
    }
}
