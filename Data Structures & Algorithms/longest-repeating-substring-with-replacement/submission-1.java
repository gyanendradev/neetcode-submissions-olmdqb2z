class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0){
            return 0;
        }
        int longestSub = 0;
        int maxFreq = 0;
        int[] map = new int[26];
        int left = 0;
        for ( int right = 0; right< s.length(); right++){
            Character c = s.charAt(right);
            map[ c - 'A'] += 1;
            maxFreq = Math.max(maxFreq, map[c - 'A']);
            if (right - left + 1 - maxFreq <= k ){
                longestSub = Math.max(longestSub, right - left + 1);
            }else{
                map[s.charAt(left) - 'A'] -= 1;
                left += 1;
            }
        }
        return longestSub;
    }
}
