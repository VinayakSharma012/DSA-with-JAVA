public class FriendsPairing {
    public static int pairing(int n)  {
        if(n ==1  || n == 2) {
            return n;
        }
        return pairing(n-1) + (n-1) * pairing(n-2);
    } 
    public static void main(String args[]) {
        System.out.println(pairing(3));
    }
    
}
