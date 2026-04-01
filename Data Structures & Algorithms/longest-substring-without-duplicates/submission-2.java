class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() == 0){
            return 0;
        }
        map.put(s.charAt(0), 0);
        Integer longestStart = 0;
        Integer longSub = 1;
        for( int i = 1; i < s.length(); i++){
            Character chars = s.charAt(i);
            if(map.containsKey(chars)){
                if(map.get(chars) < longestStart){
                    map.put(chars,i);
                }else{
                    longestStart = map.get(chars) + 1;
                    map.put(chars,i);
                }
            }else{
                map.put(chars, i);
            }
            longSub = Math.max(longSub, i - longestStart + 1);

        }
        return longSub;
    }
}
