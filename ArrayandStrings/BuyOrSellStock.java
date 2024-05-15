package ArrayandStrings;
//this code is for mx profit not total profit
public class BuyOrSellStock {
    public int Trading(int stocks[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxp = 0;
        for(int i=0;i<stocks.length;i++) {
            if(buyprice < stocks[i]) {
                int profit = stocks[i] - buyprice;
                maxp = Math.max(maxp,profit);
            }
            else {
                buyprice = stocks[i];
            }
        }
        return maxp;
    }
    public static void main(String args[]) {
        int prices[] ={7,1,5,3,6,4};
        BuyOrSellStock obj = new BuyOrSellStock();
        int maxprofit = obj.Trading(prices);
        System.out.println(maxprofit);
    }
}
