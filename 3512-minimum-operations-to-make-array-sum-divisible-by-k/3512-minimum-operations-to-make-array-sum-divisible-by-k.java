class Solution {
    public int minOperations(int[] nums, int k) {
        
        int sum=0;
        
        for(int n:nums){
            sum+=n;
        }

        int rem=sum%k;

        if(rem==0){
            return 0;
        }
        return rem;
    }
}