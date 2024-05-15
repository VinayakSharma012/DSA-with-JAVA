package Linkedlist;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    //methodds
    
    public void addfirst(int data) {
        //step1- create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        //step2- newnode next = head
        newNode.next = head; //link
        //step3- update head
        head = newNode; //point to new node
    }
    public void addlast(int data) {
        //step1- create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void traverse() {
        Node temp = head;
        if(head == null) {
            System.out.println("empty linked list........");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void addmiddle(int data,int idx) {
        //step1- create new node
        Node newNode = new Node(data);
        size++;
        if(idx == 0) {
            addfirst(data);
        }
        Node temp = head; int i = 0;
        while(i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public void size() {
        System.out.println(size);
    }
    public void removeFirst() {
        if(size == 0) {
            System.out.println("LinkedList is empty........");
            return;
        }
        if(size == 1) {
            System.out.println("deleted element from first is :"+head.data);
            head = null;
            size = 0;
            return;
        }
        System.out.println("deleted element from first is :"+head.data);
        head = head.next;
        size--;
    }
    public void removeLast() {
        if(size == 0) {
            System.out.println("LinkedList is empty........");
            return;
        }
        if(size == 1) {
            System.out.println("deleted element from last is :"+tail.data);
            tail = null;
            size = 0;
            return;
        } 
        //prev node : i = size-2;
        Node prev = head;
        for(int i=0;i<size-2;i++) {
            prev = prev.next;
        }
        System.out.println("deleted element from last is :"+prev.next.data);
        prev.next = null;
        tail = prev;
        size--;
    }
    public int search(int key) {
        int i = 0;
        Node temp = head;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int HelperRecSearch(int key,Node head) {
        //base case
        if(head == null) {
            return -1;
        }
        //kaam
        else if(head.data == key) {
            return 0;
        }
        int idx = HelperRecSearch(key, head.next);
        if(idx == -1) {
            return -1;
        }
            return idx+1;
    }
    public int RecursiveSearch(int key) {
        return HelperRecSearch(key, head);
    }
    public void reverse() { //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void removeMiddle(int n) { // remove nth from end;
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n==sz) {
            head = head.next; //rmvoe first
            return;
        }
        //sz-n
        int i=1;
        int iTOfind = sz-n;
        Node prev = head;
        while(i < iTOfind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public Node findMid(Node head) { //slowfastapproach
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        return slow;
    }
    public boolean isPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        //1-find mid
        Node midNode = findMid(head);
        //2-reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //rigth half head
        Node left = head;

        //3-check left and right
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean isCycle(Node head) {
        if(head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
    public void removeCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            return;
        }
        //meeting point
        slow = head;
        Node prev = null;
        while(slow!=fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle -> last.next = null;
        prev.next = null;
    }
    private Node getMid(Node head) { //slowfastapproach
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        return slow;
    }
    public Node Mergesort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left and righ ms
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = Mergesort(head);
        Node newRight = Mergesort(rightHead);

        //merge
        return Merge(newLeft,newRight);
    }
    private Node Merge(Node head1,Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        Node mid = slow;
        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        //alternative merge - zigzag merge
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addfirst(3);
        ll.addfirst(4);
        ll.addfirst(5);
        ll.traverse();
        ll.size();
        System.out.println("element is at:"+ ll.search(2));
        System.out.println("element is at:"+ ll.RecursiveSearch(1  ));
        ll.reverse();
        ll.traverse();
        ll.size();
        /* head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        System.out.println("before removing cycle :");
        System.out.println(ll.isCycle(head));
        ll.removeCycle();
        System.out.println("after removing cycle :");
        System.out.println(ll.isCycle(head)); */
        ll.traverse();

        ll.head =ll.Mergesort(ll.head);
        ll.traverse();
        ll.zigZag();
        ll.traverse();
    }
}
