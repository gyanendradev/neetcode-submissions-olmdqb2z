class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ansArr = new int[n];
        List<int[]> monotonicDecreasingStack = new ArrayList<>();
        for(int i = n-1; i >= 0; i--){
            if(monotonicDecreasingStack.size() == 0){
                monotonicDecreasingStack.add(new int[]{i, temperatures[i]});
            }else{
                int lastLargestElem = monotonicDecreasingStack.get(monotonicDecreasingStack.size()-1)[1];
                while( lastLargestElem <= temperatures[i]){
                    monotonicDecreasingStack.remove(monotonicDecreasingStack.size()-1);
                    if(monotonicDecreasingStack.size() > 0){
                        lastLargestElem = monotonicDecreasingStack.get(monotonicDecreasingStack.size()-1)[1];
                    }else{
                        break;
                    }
                }
                if(monotonicDecreasingStack.size() > 0){
                    ansArr[i] = monotonicDecreasingStack.get(monotonicDecreasingStack.size()-1)[0] - i;
                }
                monotonicDecreasingStack.add(new int[]{i, temperatures[i]});
            }
        }
        return ansArr;
    }
}
