class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;

        for(int i=0; i<nums.length; i++){

            sum += nums[i];
            int ques = sum - k;
            int freq = map.getOrDefault(ques,0);
            result += freq;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}