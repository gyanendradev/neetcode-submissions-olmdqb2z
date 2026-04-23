class Solution {
    public int maxProduct(int[] nums) {
        int n =nums.length;
        int max_product = nums[0];
        int min_product = nums[0];
        int max_ans = nums[0];
        for(int i = 1; i < n; i++){
            int use_max = max_product * nums[i];
            int use_min = min_product * nums[i];
            int curr_max = maxOfThree(use_max, use_min, nums[i]);
            int curr_min = minOfThree(use_max, use_min, nums[i]);
            max_ans = Math.max(max_ans, curr_max);
            max_product = curr_max;
            min_product = curr_min;
        }        
        return max_ans;
    }
    public int maxOfThree(int a, int b, int c){
        return a > b ? ( a > c ? a : c) : (b > c ? b : c);
    }

    public int minOfThree(int a, int b, int c){
        return a < b ? ( a < c ? a : c) : (b < c ? b : c);
    }
}
