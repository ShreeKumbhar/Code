class Solution {
    public int findMaxLength(int[] nums) {
        
        int one = 0;
        int zero = 0;
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            if(nums[i]==1){
                one++;
            }
            else{
                zero++;
            }

            int diff = zero - one;

            if(diff == 0){
                result = Math.max(result,i+1);
                continue;
            }

            if(!map.containsKey(diff)){
                map.put(diff,i);
            }
            else{
                int idx = map.getOrDefault(diff,0);
                int len = i - idx;
                result = Math.max(result,len);
            }
        }

        return result;
    }
}
