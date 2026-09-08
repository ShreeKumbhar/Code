class Solution {
    public int pivotIndex(int[] nums) {
        
        int left = 0;
        int right = 0;
        int totalSum = 0;

        for(int i:nums){
            totalSum += i;
        }

        for(int i=0; i<nums.length; i++){
            right = totalSum - nums[i] - left;
            if(left == right){
                return i;
            }
            left += nums[i];
        }

        return -1;
    }
}