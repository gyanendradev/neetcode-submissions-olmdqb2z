class Solution {
    private Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        HashMap<String, Boolean> wordHash = new HashMap<>();
        for(int j =0; j< wordDict.size(); j++){
            wordHash.put(wordDict.get(j), true);
        }
        return checkRecursively(s, wordHash, 0);
    }
    public boolean checkRecursively(String s, HashMap wordHash, int start){
        if(memo.containsKey(start) == true){
            return memo.get(start);
        }
        boolean found = false;
        for(int i = start ; i < s.length(); i++){
            if(wordHash.containsKey(s.substring(start, i+1))){
                found = found || checkRecursively(s, wordHash,i+1);
            }
        }
        memo.put(start, found);
        return found;
    }
}
