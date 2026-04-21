class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        if(n==3){
            return nums[0] > nums[1] ? (nums[0] > nums[2] ? nums[0] : nums[2]) : (nums[1] > nums[2] ? nums[1] : nums[2]);
        }
        int ans1 = maxLoot(nums, 0, n-1);
        int ans2 = maxLoot(nums, 1, n);
        return Math.max(ans1, ans2);
    }
    public int maxLoot(int[] nums, int start, int end){
        int[] ans = new int[end - start];
        ans[0] = nums[start];
        start++;
        ans[1] = Math.max(nums[start], nums[start-1]);
        start++;
        int i = 2;
        while(start < end){
            ans[i] = Math.max(ans[i-1], nums[start] + ans[i-2]);
            start++;
            i++;
        }
        return Math.max(ans[ans.length-1], ans[ans.length-1]);
    }
}
