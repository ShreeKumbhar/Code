class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }        

        int length=0;

        for(int n:set){
            if(!set.contains(n-1)){
                int count=1;
                while(set.contains(n+count)){
                    count++;
                }
                length=Math.max(length,count);
            }
        }

        return length;
    }
}