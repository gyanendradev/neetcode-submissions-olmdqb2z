class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount + 1];
        Arrays.sort(coins);
        int coinLength = coins.length;
        if(amount == 0){
            return 0;
        }
        ans[0] = 0;
        for(int i = 1; i < amount + 1; i++){
            int requiredCoins = Integer.MAX_VALUE;
            for(int j = coinLength - 1; j>=0; j--){
                if(i - coins[j] >= 0 ){
                    if(ans[i - coins[j]] != -1){
                        requiredCoins = Math.min(ans[i - coins[j]] + 1, requiredCoins);
                    }
                }
            }
            if(requiredCoins == Integer.MAX_VALUE){
                requiredCoins = -1;
            }
            ans[i] = requiredCoins;
        }
        return ans[amount];
    }
}
