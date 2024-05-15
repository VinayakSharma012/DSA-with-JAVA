public class BinaryStrings {
    public static void printBinarystr(int n,int LastPLace,String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        printBinarystr(n-1, 0, str+"0");
        if(LastPLace == 0) {
        printBinarystr(n-1, 1, str+"1");
    }
}
    public static void main(String args[]) {
        printBinarystr(2, 0, "");
    }
    
}
