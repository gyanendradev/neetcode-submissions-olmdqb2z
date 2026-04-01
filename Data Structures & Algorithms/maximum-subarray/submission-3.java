class Solution {
    public int maxSubArray(int[] nums) {
        Integer maxSum = nums[0];
        Integer runningSum = nums[0];
        for( int i =1 ; i< nums.length; i++){
            if(nums[i]> maxSum){
                maxSum = nums[i];
            }
            if(runningSum + nums[i] > maxSum){
                maxSum = runningSum + nums[i];
            }
            if(runningSum + nums[i] < 0){
                runningSum = 0;
            }else{
                runningSum += nums[i];
            }
        }
        return maxSum;
    }
}
