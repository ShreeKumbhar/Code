class Solution {

    public static int solveMem(int n,int[] dp){

        if(n<=1){
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int ans=0;
        for(int i=1;i<=n;i++){
            ans+=solveMem(i-1,dp)*solveMem(n-i,dp);
        }

        return dp[n]=ans;
    }

    public int numTrees(int n) {
        
        // if(n<=1){
        //     return 1;
        // }

        // int ans=0;

        // for(int i=1;i<=n;i++){
        //     ans+=numTrees(i-1) * numTrees(n-i);
        // }

        // return ans;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solveMem(n,dp);
    }
}