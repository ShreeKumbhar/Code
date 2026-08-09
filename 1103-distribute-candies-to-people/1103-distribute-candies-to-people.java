class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        
        int[] ans=new int[num_people];
        int i=0;
        int j=1;

        while(candies > 0){

            int give=Math.min(j,candies);
            ans[i]+=give;
            candies-=give;
            j++;
            i++;
            if(i==num_people){
                i=0;
            }
        }

        return ans;
    }
}