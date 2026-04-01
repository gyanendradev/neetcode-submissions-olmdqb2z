class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> foundMap = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            if(foundMap.containsKey(target-nums[i])){
                return new int[]{foundMap.get(target-nums[i]),i};
            }else{
                foundMap.put(nums[i],i);
            }
        }
        return new int[]{0,0};
    }
}
