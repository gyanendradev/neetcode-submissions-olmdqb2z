class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayList<int[]> monstaticDecrerasingStack = new ArrayList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = n-1 ; i>=0 ; i--){
            int m = monstaticDecrerasingStack.size();
            if(m == 0){
                monstaticDecrerasingStack.add(new int[]{temperatures[i], i});
                ans[i] = 0;
            }else{
                while(m > 0 && temperatures[i] >= monstaticDecrerasingStack.get(m-1)[0]){
                    monstaticDecrerasingStack.remove(m-1);
                    m = monstaticDecrerasingStack.size();
                }
                if(m > 0 && temperatures[i] < monstaticDecrerasingStack.get(m-1)[0]){
                    ans[i] = monstaticDecrerasingStack.get(m-1)[1] - i;
                }
                monstaticDecrerasingStack.add(new int[]{temperatures[i], i});
            }
        }
        return ans;
    }
}
