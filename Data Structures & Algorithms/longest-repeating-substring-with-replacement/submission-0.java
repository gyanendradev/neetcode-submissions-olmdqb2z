class Solution {
    public int characterReplacement(String s, int k) {
        int longestSub = 0;
        for ( int i =0; i< s.length(); i++){
            int[] map = new int[26];
            int maxFreq = 1;
            map[s.charAt(i) - 'A'] += 1;
            for(int j = i +1 ; j < s.length(); j++){
                map[s.charAt(j) - 'A'] += 1;
                int length = j - i + 1;
                maxFreq = Math.max(maxFreq, map[s.charAt(j) - 'A']);
                if(length - maxFreq - k <= 0){
                    longestSub = Math.max(longestSub, length );
                }else{
                    break;
                }
            }
        }
        return longestSub;
    }
}
