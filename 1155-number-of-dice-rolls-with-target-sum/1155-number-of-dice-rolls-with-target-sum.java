class Solution {

    static int mod=1000000007;

    // public static int solve(int dice,int faces,int target){

    //     if(target<0){
    //         return 0;
    //     }
    //     if(dice==0 && target!=0){
    //         return 0;
    //     }
    //     if(dice!=0 && target==0){
    //         return 0;
    //     }
    //     if(dice==0 && target==0){
    //         return 1;
    //     }

    //     int ans=0;
    //     for(int i=1;i<=faces;i++){
    //         ans+=solve(dice-1,faces,target-i);
    //     }
    //     return ans%mod;
    // }

    // public static int solveMem(int dice,int faces,int target,int[][]dp){

    //     if(target<0){
    //         return 0;
    //     }
    //     if(dice==0 && target!=0){
    //         return 0;
    //     }
    //     if(dice!=0 && target==0){
    //         return 0;
    //     }
    //     if(dice==0 && target==0){
    //         return 1;
    //     }

    //     if(dp[dice][target]!=-1){
    //         return dp[dice][target];
    //     }

    //     int ans=0;
    //     for(int i=1;i<=faces;i++){
    //         ans= (ans+solveMem(dice-1,faces,target-i,dp))%mod;
    //     }

    //     dp[dice][target]=ans;
    //     return dp[dice][target];
    // }

        public static int solveSO(int d, int f, int t){

        int[] curr=new int[t+1];
        int[] prev=new int[t+1];
        Arrays.fill(curr,0);
        Arrays.fill(prev,0);

        prev[0]=1;

        for(int dice = 1; dice <=d; dice++){
            Arrays.fill(curr, 0);
            for(int target = 1; target <=t; target++){
                int ans=0;
                for(int i=1;i<=f;i++){
                    if(target-i >=0)
                        ans=(ans+prev[target-i])%mod;
                }
                curr[target]=ans;
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return prev[t];
    }

    // public static int solveTab(int n, int k, int t){
    //     int[][] dp=new int[n+1][t+1];
    //     for(int[] i:dp){
    //         Arrays.fill(i,0);
    //     }

    //     dp[0][0]=1;

    //     for(int dice=1;dice<=n;dice++){
    //         for(int target=1;target<=t;target++){
    //             int ans=0;
    //             for(int i=1;i<=k;i++){
    //                 if(target-i>=0)
    //                     ans= (ans+dp[dice-1][target-i])%mod;
    //             }
    //             dp[dice][target]=ans;
    //         }
    //     }

    //     return dp[n][t];
    // }

    public int numRollsToTarget(int n, int k, int target) {
        // int[][] dp=new int[n+1][target+1];
        // for(int[] i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return solveMem(n,k,target,dp);
        return solveSO(n,k,target);
    }
}