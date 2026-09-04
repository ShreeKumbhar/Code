class Solution {

    public static int findMax(int[] freq){
        int max = -1;
        for(int i=0 ; i<256 ; i++){
            max = Math.max(max,freq[i]);
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        
        int low = 0;
        int result = -1;
        int[] freq = new int[256];

        for(int high = 0 ; high<s.length();high++){

            freq[s.charAt(high)]++;
            int len = high - low + 1;
            int maxCnt = findMax(freq);
            int diff = len - maxCnt;

            while(diff > k){
                freq[s.charAt(low)]--;
                low++;
                maxCnt = findMax(freq);
                len = high - low + 1;
                diff = len - maxCnt;
            }

            len = high - low + 1;
            result = Math.max(result,len);
        }

        return result;
    }
}