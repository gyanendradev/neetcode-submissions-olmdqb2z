class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if(strs.length == 0){
            return ans;
        }
        ans = strs[0];
        for(int i = 1; i < strs.length; i++){
            int loopFor = Math.min(ans.length(), strs[i].length());
            if(loopFor == 0){
                ans = "";
                break;
            }
            boolean isCompleteWord = true;
            for( int j = 0; j < loopFor; j++){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    ans = ans.substring(0, j);
                    isCompleteWord = false;
                    break;
                }
            }
            if(isCompleteWord && (ans.length() >= strs[i].length())){
                ans = strs[i];
            }
        }
        return ans;
    }
}