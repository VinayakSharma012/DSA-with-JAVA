class BitOperations {
    public static int getIthBit(int n,int i) {
        int BitMask = 1<<i;
        if((n & BitMask) == 0) {
            return 0;
        }
        else {
             return 1;
        }
    }
    public static int setIthBit(int n,int i) {
        int BitMask = 1<<i;
        return n | BitMask;
        }
    
    public static int clearIthBit(int n,int i) {
        int BitMask = ~(1<<i);
        return n & BitMask;
    }
    
    public static int updateIthBit(int n,int i,int newBit) {
      /*   if(newBit == 0) {
            return clearIthBit(n, i);
        }
        else {
            return setIthBit(n, i);
        } */

        n = clearIthBit(n, i);
        int BitMask = newBit<<i;
        return n | BitMask;
    }
    public static int clearIBits(int n,int i) {
        int BitMask = (~0)<<i;
        return n & BitMask;
    }
    public static int clearRangeOfBits(int n,int i,int j) {
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int BitMask = a | b;
        return n & BitMask;
    }
    public static void main(String args[]) {
        System.out.println(getIthBit(10,2));
        System.out.println(setIthBit(10,2));
        System.out.println(clearIthBit(10,1));
        System.out.println(updateIthBit(10,2,1));
        System.out.println(clearIBits(15,2));
        System.out.println(clearRangeOfBits(10,2,4));
    }
}