class Solution {
    public int maxSubArray(int[] nums) {
        Integer maxSum = nums[0];
        for ( int i =0; i< nums.length; i++){
            int sumOfRow = nums[i];
            for (int j = i+1; j< nums.length; j++){
                sumOfRow += nums[j];
                if(sumOfRow> maxSum){
                    maxSum = sumOfRow;
                }
            }
            if(sumOfRow> maxSum){
                    maxSum = sumOfRow;
                }
        }
        return maxSum;
    }
}
