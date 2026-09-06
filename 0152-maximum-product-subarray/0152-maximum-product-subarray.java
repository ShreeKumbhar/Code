class Solution {
    public int maxProduct(int[] nums) {
        
        int ans = nums[0];
        int minEnd = nums[0];
        int maxEnd = nums[0];

        for(int i=1 ; i<nums.length ; i++){

            int v1 = nums[i];
            int v2 = minEnd * nums[i];
            int v3 = maxEnd * nums[i];
            minEnd = Math.min(v1,Math.min(v2,v3));
            maxEnd = Math.max(v1,Math.max(v2,v3));
            ans = Math.max(ans,Math.max(minEnd,maxEnd));
        }

        return ans;
    }
}