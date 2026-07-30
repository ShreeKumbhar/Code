class Solution {

    // public static int solveMem(int n,int[] dp){

    //     if(n<=1){
    //         return 1;
    //     }

    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }

    //     int ans=0;
    //     for(int i=1;i<=n;i++){
    //         ans+=solveMem(i-1,dp)*solveMem(n-i,dp);
    //     }

    //     return dp[n]=ans;
    // }

    // public static int solveTab(int n){

    //     int[] dp=new int[n+1];
    //     Arrays.fill(dp,0);

    //     dp[0]=1;
    //     dp[1]=1;

    //     for(int node=2;node<=n;node++){
    //         for(int root=1;root<=node;root++){
    //             dp[node]+=dp[root-1]*dp[node-root];
    //         }
    //     }
    //     return dp[n];
    // }   

    public static int optimize(int n){

        long ans=1;

        for(int i=0;i<n;i++){
            ans=ans*(2*n-i)/(i+1);
        }

        return (int) (ans/(n+1));
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
        // int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        return optimize(n);
    }
}