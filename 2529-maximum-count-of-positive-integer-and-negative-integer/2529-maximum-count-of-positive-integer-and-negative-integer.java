class Solution {

    public static int binarySearchNegative(int[] nums){

        int res = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right-left)/2;

            if(nums[mid] < 0){
                res = mid + 1;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return res;
    }   

    public static int binarySearchPositive(int[] nums){

        int res = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right-left)/2;

            if(nums[mid] > 0){
                res = nums.length - mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    } 

    public int maximumCount(int[] nums) {
        
        int minCnt = binarySearchNegative(nums);
        int maxCnt = binarySearchPositive(nums);
        return Math.max(minCnt,maxCnt);

    }
}