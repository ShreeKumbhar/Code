class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev=0;
        int curr=1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i) > nums.get(i-1)){
                curr++;
            }
            else{
                prev=curr;
                curr=1;
            }
            if(curr/2>=k || Math.min(curr,prev)>=k){
                return true;
            }
        }

        return curr/2>=k || Math.min(curr,prev)>=k;
    }
}