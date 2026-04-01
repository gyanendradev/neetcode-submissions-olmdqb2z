class Solution {
    public int maxProfit(int[] prices) {
        Integer maxProfit = 0;
        Integer lowestBuyPossible = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] < lowestBuyPossible){
                lowestBuyPossible = prices[i];
            }else if((prices[i]- lowestBuyPossible) > maxProfit) {
                maxProfit = prices[i] - lowestBuyPossible;
            }
        }
        return maxProfit;
    }
}
