class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] map = new int[26];
        int maxAns = 0;
        int maxOccurence = 0;
        while( right < s.length()){
            System.out.print("left : " + left + " roght : "+ right +"start \n");
            char ch = s.charAt(right);
            map[ch - 'A'] += 1;
            if(map[ch - 'A'] > maxOccurence ){
                maxOccurence = map[ch - 'A'];
            }
            if(right - left + 1 - maxOccurence <= k){
                maxAns = Math.max(right-left+1, maxAns);
            }else{
                map[s.charAt(left) - 'A'] -= 1;
                left += 1;
            }
            right += 1;
            System.out.print("left : " + left + " roght : "+ right +"end \n");
        }
        return maxAns;
    }
}
