class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        int res = -1;

        while( left <= right ){

            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                res = mid;
                return res;
            }
            if( nums[mid] > nums[nums.length-1]){

                if(nums[mid] < target){
                    left = mid + 1;
                }
                else{
                    if(nums[0] > target){
                        left = mid + 1;
                    }
                    else{
                        right = mid - 1;
                    }
                }
            }
            else{
                if(nums[mid] > target){
                    right = mid - 1;
                }
                else{
                    if(nums[nums.length-1] < target){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
            }
        }
        return res;
    }
}