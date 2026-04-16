class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int i =0;
        int n = intervals.length;
        while(i < n){
            int intervalStart = intervals[i][0];
            int intervalEnd = intervals[i][1];
            int j = i+1;
            while(j < n && intervalEnd >= intervals[j][0]){
                intervalEnd = Math.max(intervals[j][1], intervalEnd);
                j +=1 ;
            }
            ans.add(new int[]{intervalStart, intervalEnd});
            i = j;
        }
        int[][] result = ans.toArray(new int[0][]);
        return result;
    }
}
