class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.isEmpty()){
            return 0;
        }

        int low = 0;
        HashMap<Character,Integer> map=new HashMap<>();
        int result = Integer.MIN_VALUE;

        for( int high = 0 ; high<s.length() ; high++){

            map.put(s.charAt(high),map.getOrDefault(s.charAt(high),0)+1);
            int k = high - low + 1;

            while( map.size() < k){

                map.put(s.charAt(low),map.getOrDefault(s.charAt(low),0)-1);
                if(map.get(s.charAt(low))==0){
                    map.remove(s.charAt(low));
                }
                low++;
                k = high - low + 1;
            }

            int len = high - low + 1;
            result = Math.max(result,len);
        }
        return result;
    }
}