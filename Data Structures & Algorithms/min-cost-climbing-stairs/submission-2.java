class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int two_step_back = cost[0];
        int one_step_back = cost[1];
        int ans = 0;
        for( int i=2; i < n ; i++){
            ans = cost[i] + Math.min(one_step_back, two_step_back);
            two_step_back = one_step_back;
            one_step_back = ans;
        }
        return Math.min(one_step_back, two_step_back );
    }
}
