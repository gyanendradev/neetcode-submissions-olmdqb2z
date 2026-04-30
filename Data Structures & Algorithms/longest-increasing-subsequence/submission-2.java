class Solution {
    private int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for(int i = 0; i<n;i++){
            for(int j =0;j<n;j++){
                memo[i][j] = -1;
            }
        }
        return dfs(nums, 0, -1);
    }
    public int dfs(int[] nums,int start, int lastTakenIndex){
        if(start == nums.length){
            return 0;
        }
        if(memo[start][lastTakenIndex + 1] != -1){
            return memo[start][lastTakenIndex + 1];
        }
        int ans = 0;
        int taken = 0;
        int notTaken;
        if(lastTakenIndex == -1 || nums[start] > nums[lastTakenIndex]){
            taken = 1 + dfs(nums, start+1, start);
        }
        notTaken = dfs(nums, start+1, lastTakenIndex);
        ans = Math.max(taken, notTaken);
        memo[start][lastTakenIndex+1] = ans;
        return ans;
    }
}
