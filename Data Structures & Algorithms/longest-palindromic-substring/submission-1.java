class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        for(int i = 0; i < s.length(); i++){
            String palin1 = findValidPalindrome(s, i-1, i, n);
            String palin2 = findValidPalindrome(s, i, i, n);
            if(palin1.length() > ans.length()){
                ans = palin1;
            }
            if(palin2.length() > ans.length()){
                ans = palin2;
            }
        }
        return ans;
    }
    public String findValidPalindrome(String s, int left, int right, int length){
        while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){
            left -= 1;
            right += 1;
        }
        return s.substring(left + 1, right);
    }
}
