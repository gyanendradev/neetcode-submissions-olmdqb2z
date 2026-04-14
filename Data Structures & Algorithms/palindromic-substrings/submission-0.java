class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i< n; i++){
            ans += allValidPalindrome(s, i, n);
        }
        return ans;
    }
    public int allValidPalindrome(String s, int i, int length){
        int count = 1;
        int left = i;
        int right = i + 1;
        while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){
            count += 1;
            left -= 1;
            right += 1;
        }
        left = i - 1;
        right = i + 1;
        while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)){
            count += 1;
            left -= 1;
            right += 1;
        }
        return count;
    }
}
