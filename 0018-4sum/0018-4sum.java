class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){

                int left = j+1;
                int right = n-1;

                long required =(long) target - (nums[i]+nums[j]);

                if(i > 0 && nums[i] == nums[i-1]) continue;
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                while( left < right){

                    long sum=(long) nums[left]+nums[right];
                    if(sum == required){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;

                        while(left < right && nums[left]==nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }  
                    else if(required < sum){
                        right--;
                    } 
                    else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}