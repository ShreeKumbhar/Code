class Solution {
    public int longestPalindrome(String s) {
        
        int[] freq = new int[128];

        int result = 0;
        boolean odd = false;

        for(char ch : s.toCharArray()){
            freq[ch]++;
        }

        for(int val : freq){
            if(val % 2 == 0){
                result += val;
            }
            else{
                result += val - 1;
                odd = true;
            }
        }

        if(odd){
            result++;
        }

        return result;
    }
}