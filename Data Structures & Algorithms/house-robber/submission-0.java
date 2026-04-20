class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        if(n == 0){
            return 0;
        }
        if(n ==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        ans[0] = nums[0];
        ans[1] = nums[1];
        ans[2] = nums[0] + nums[2];
        for(int i = 3; i<n ; i++){
            ans[i] = nums[i] + Math.max(ans[i-2], ans[i-3]);
        }
        return Math.max(ans[n-1], ans[n-2]);
    }
}
