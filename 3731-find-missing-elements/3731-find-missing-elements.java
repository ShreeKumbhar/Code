class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list=new ArrayList<>();

        Arrays.sort(nums);
        int n=nums.length;

        int first=nums[0];
        int last=nums[n-1];

        int j=0;
        for(int i=first;i<=last;i++){
            if(nums[j]==i && j<nums.length){
                j++;
            }
            else{
                list.add(i);
            }
        }

        return list;
    }
}