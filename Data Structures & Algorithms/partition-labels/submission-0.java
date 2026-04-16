class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            Character ch = s.charAt(i);
            lastOccurence.put(ch, i);
        }
        int currSize = 0;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int lastIndexOfCurrSet = 0;
        while(i < s.length()){
            if(currSize == 0){
                currSize += 1;
                lastIndexOfCurrSet = Math.max(lastIndexOfCurrSet,lastOccurence.get(s.charAt(i)));
            }else{
                if(i > lastIndexOfCurrSet){
                    ans.add(currSize);
                    currSize = 1;
                    lastIndexOfCurrSet = Math.max(i,lastOccurence.get(s.charAt(i)));
                }else{
                    currSize += 1;
                    lastIndexOfCurrSet = Math.max(lastIndexOfCurrSet,lastOccurence.get(s.charAt(i)));
                }
            }
            i += 1;
        }
        if(currSize > 0){
            ans.add(currSize);
        }
        return ans;
    }
}
