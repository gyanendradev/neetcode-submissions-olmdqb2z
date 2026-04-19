class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n];
        ans[0] = cost[0];
        ans[1] = cost[1];
        for( int i=2; i < n ; i++){
            ans[i] = cost[i] + Math.min(ans[i-1], ans[i-2]);
        }
        return Math.min(ans[n-1], ans[n-2]);
    }
}
