class Solution {

    public static boolean compare(int[] present, int[] needed){

        for(int i=0;i<256;i++){
            if(present[i] < needed[i]){
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        
        int low = 0;
        int res = Integer.MAX_VALUE;
        int start = 0;

        int[] present = new int[256];
        int[] needed = new int[256];

        for(char ch:t.toCharArray()){
            needed[ch]++;
        }

        for(int high = 0 ; high<s.length() ; high++){

            present[s.charAt(high)]++;

            while(compare(present,needed)){

                int len = high - low + 1;

                if(res > len){
                    res = len;
                    start = low;
                }
                present[s.charAt(low)]--;
                low++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }
}