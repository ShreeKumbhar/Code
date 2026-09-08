class Solution {

    public static int solveMax(int[] nums){
        int bestEnd = nums[0];
        int result = nums[0];
        for(int i = 1; i<nums.length; i++){
            int v1 = nums[i];
            int v2 = bestEnd + nums[i];
            bestEnd = Math.max(v1,v2);
            result = Math.max(result,bestEnd);
        }
        return result;
    }

    public static int solveMin(int[] nums){
        int bestEnd = nums[0];
        int result = nums[0];
        for(int i = 1; i<nums.length; i++){
            int v1 = nums[i];
            int v2 = bestEnd + nums[i];
            bestEnd = Math.min(v1,v2);
            result = Math.min(result,bestEnd);
        }
        return result;
    }

    public int maxSubarraySumCircular(int[] nums) {
        
        int maxAns = solveMax(nums);
        int minAns = solveMin(nums);
        int totalSum = 0;
        for(int i : nums){
            totalSum += i;
        }

        int ansMin = totalSum - minAns;

        if(maxAns < 0){
            return maxAns;
        }
        return Math.max(maxAns,ansMin);

    }
}