class Solution {

    public static int binarySearchFirst(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid -1;
            }
            else{
                res = mid;
                right = mid -1;
            }
        }
        return res;
    }

    public static int binarySearchLast(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid -1;
            }
            else{
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        
        int first = binarySearchFirst(nums,target);
        int last = binarySearchLast(nums,target);
        return new int[]{first,last};
    }
}