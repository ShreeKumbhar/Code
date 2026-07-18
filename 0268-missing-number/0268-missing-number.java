class Solution {
    public int missingNumber(int[] nums) {
        
        // Arrays.sort(nums);

        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=i){
        //         return i;
        //     }
        // }

        // return nums.length;
        int len=nums.length;
        int expectedSum= len*(len+1)/2;
        int actualSum=0;
        
        for(int n:nums){
            actualSum+=n;
        }

        return expectedSum-actualSum;

    }
}