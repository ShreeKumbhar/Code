class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n/2];
        int res = 0;

        for(int i=0; i<nums.length; i++){
            res += Math.abs(nums[i]-mid);
        }

        return res;
    }
}