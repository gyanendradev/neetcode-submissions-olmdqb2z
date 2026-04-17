class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>(Arrays.asList(intervals));
        if(intervalsList.size() == 0){
            intervalsList.add(newInterval);
            return intervalsList.toArray(new int[0][]);
        }
        if( intervalsList.get(0)[0] > newInterval[1]){
            intervalsList.add(0, newInterval);
            return intervalsList.toArray(new int[0][]);
        }
        boolean added = false;
        for( int i =0; i < intervalsList.size(); i++){
            int startInterval = intervalsList.get(i)[0];
            int endInterval = intervalsList.get(i)[1];
            if( newInterval[0] >= startInterval && newInterval[0] <= endInterval){
                int j = i+1;
                int n = intervalsList.size();
                endInterval = Math.max(intervalsList.get(i)[1], newInterval[1]);
                while(j < n && intervalsList.get(j)[0] <= endInterval){
                    endInterval = Math.max(intervalsList.get(j)[1], newInterval[1]);
                    intervalsList.remove(j);
                    n = intervalsList.size();
                }
                intervalsList.set(i, new int[]{startInterval,endInterval});
                added = true;
                break;
            }else if( newInterval[1] >= startInterval && newInterval[0] <= startInterval ){
                startInterval = Math.min(newInterval[0], intervalsList.get(i)[0]);
                endInterval = Math.max(intervalsList.get(i)[1], newInterval[1]);
                int j = i ;
                int n = intervalsList.size();
                while(j < n && (intervalsList.get(j)[0] <= endInterval || intervalsList.get(j)[1] <= endInterval)){
                    endInterval = Math.max(intervalsList.get(j)[1], newInterval[1]);
                    intervalsList.remove(j);
                    n = intervalsList.size();
                }
                if( i < n){
                    intervalsList.add(i, new int[]{startInterval,endInterval});
                }else{
                    intervalsList.add( new int[]{startInterval,endInterval});
                }
                added = true;
                break;
            }else if ( i-1 >= 0 && newInterval[0] > intervalsList.get(i-1)[1] && newInterval[1] < intervalsList.get(i)[0]){
                intervalsList.add(i, newInterval);
                added = true;
                break;
            }
        }
        if(added == false){
            intervalsList.add(newInterval);
        }
        return intervalsList.toArray(new int[0][]);
    }
}
