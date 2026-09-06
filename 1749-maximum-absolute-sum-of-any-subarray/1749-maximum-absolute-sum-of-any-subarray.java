class Solution {

    public static int solveMaximum(int[] nums){
        int result = nums[0];
        int bestEnd = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            int v1 = bestEnd + nums[i];
            int v2 = nums[i];
            bestEnd = Math.max(v1,v2);
            result = Math.max(result,bestEnd);
        }
        return result;
    }

    public static int solveMinimum(int[] nums){
        int result = nums[0];
        int bestEnd = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            int v1 = bestEnd + nums[i];
            int v2 = nums[i];
            bestEnd = Math.min(v1,v2);
            result = Math.min(result,bestEnd);
        }
        return result;
    }

    public int maxAbsoluteSum(int[] nums) {
        int max = solveMaximum(nums);
        int min = solveMinimum(nums);
        return Math.max(max, Math.abs(min));
    }
}