class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        findTarget(0, 0, target, n, nums);
        return ans;

    }
    public int findTarget(int i, int currSum, int target, int n, int[] nums){
        if(i == n){
            if(currSum ==target){
                ans +=1;
            }
            return 0;
        }
        findTarget(i+1, currSum + -1 * nums[i], target, n, nums);
        findTarget(i+1, currSum + nums[i], target, n, nums);
        return 0;
    }
}
