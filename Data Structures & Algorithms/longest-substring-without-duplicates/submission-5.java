class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        int ans = 0;
        int left = 0;
        for(int right = 0; right < s.length() ; right++){
            char ch = s.charAt(right);
            if(!hash.containsKey(ch)){
                hash.put(ch, right);
            }else{
                if(hash.get(ch) >= left){
                    left = hash.get(ch) + 1;
                }
                hash.put(ch, right);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
