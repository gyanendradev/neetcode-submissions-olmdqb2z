class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> found = new HashMap<>();
        for(int i =0 ; i<nums.length; i++){
            if(found.containsKey(nums[i])){
                return true;
            }else{
                found.put(nums[i],i);
            }
        }
        return false;
    }
}