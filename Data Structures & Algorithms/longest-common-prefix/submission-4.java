class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if(strs.length == 0){
            return ans;
        }
        ans = strs[0];
        for(int i = 1; i < strs.length; i++){
            int loopFor = Math.min(ans.length(), strs[i].length());
            int j = 0;
            while(j < loopFor){
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j ++;
            }
            ans = ans.substring(0,j);
        }
        return ans;
    }
}