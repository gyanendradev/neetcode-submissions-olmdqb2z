class Solution {
    public int maxArea(int[] heights) {
        Integer maxCapacity = 0;
        Integer start = 0;
        Integer end = heights.length - 1;
        while ( start < end ){
            Integer stored = (end - start) * Math.min(heights[start], heights[end]);
            if(stored > maxCapacity){
                maxCapacity = stored;
            }
            if(heights[start]< heights[end]){
                start += 1;
            }else{
                end -= 1;
            }
        }
        return maxCapacity;
    }
}
