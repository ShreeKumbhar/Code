class Solution {

    // public static int solveBack(int[] nums,int diff,int index){

    //     if(index<0){
    //         return 0;
    //     }

    //     int ans=0;

    //     for(int j=index-1;j>=0;j--){
    //         if(nums[index]-nums[j]==diff){
    //             ans=Math.max(ans,1+solveBack(nums,diff,j));
    //         }
    //     }
    //     return ans;
    // }

    // public static int solveRec(int[] nums,int n){

    //     if(n<=2) return n;

    //     int ans=0;

    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             ans=Math.max(ans,2+solveBack(nums,nums[j]-nums[i],i));
    //         }
    //     }

    //     return ans;
    // }

public static int solveBackMem(int[] nums,int diff,int index,Map<Integer, Integer>[] dp){

        if(index<0){
            return 0;
        }

        if(dp[index].containsKey(diff)){
            return dp[index].get(diff);
        }

        int ans=0;

        for(int j=index-1;j>=0;j--){
            if(nums[index]-nums[j]==diff){
                ans=Math.max(ans,1+solveBackMem(nums,diff,j,dp));
            }
        }

        dp[index].put(diff,ans);
        return dp[index].get(diff);
    }

    public static int solveMem(int[] nums,int n){

        Map<Integer,Integer>[] dp=new HashMap[n];

        for(int i=0;i<n;i++){
            dp[i]=new HashMap<>();
        }

        if(n<=2) return n;

        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans=Math.max(ans,2+solveBackMem(nums,nums[j]-nums[i],i,dp));
            }
        }

        return ans;
    }

    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        return solveMem(nums,n);
    }
}