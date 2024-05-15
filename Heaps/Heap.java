package Heaps;

import java.util.ArrayList;

public class Heap {
    static class heap {
        ArrayList <Integer> arr = new ArrayList<>();

        public void add(int data) {
            //add at last idx
            arr.add(data);
            int x = arr.size()-1;// x is child idx
            int parent = (x-1)/2; // parent index

            while(arr.get(x) < arr.get(parent)) { //O(log n)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x-1)/2;
            }

        }
        public int peek() {
            return arr.get(0);
        }
        private void heapify(int idx) {
            int minIdx = idx;
            int left = 2*idx + 1;
            int right = 2*idx + 2;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if(minIdx != idx) {
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove() {
            int data = arr.get(0);

            //step 1 - swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2-delete last
            arr.remove(arr.size()-1);

            //step 3 heapify
            heapify(0);
            
            return data;
    }
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }
    public static void main(String args[]) {
        heap h = new heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.print(h.peek()+" ");
            h.remove();
        }
    }
}

/* for max heap just do minidx to max idx and reverse sign in heapify process */
