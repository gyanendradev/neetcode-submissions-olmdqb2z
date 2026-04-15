class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==0){
            return true;
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 0; i<n; i++){
            if(ans[i] == 0){
                return false;
            }
            for(int j = i+1 ; j < Math.min(i + 1 + nums[i], n); j++){
                ans[j] = 1;
            }
        }
        return ans[n-1] == 1 ? true : false;
    }
}
