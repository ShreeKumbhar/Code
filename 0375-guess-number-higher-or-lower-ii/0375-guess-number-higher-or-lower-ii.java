class Solution {

    public static int solveRec(int start,int end){

        if(start>=end){
            return 0;
        }

        int ans=Integer.MAX_VALUE;

        for(int i=start;i<=end;i++){
            ans=Math.min(ans,i+Math.max(solveRec(start,i-1),solveRec(i+1,end)));
        }
        return ans;
    }

    public static int solveMem(int start,int end,int[][] dp){

        if(start>=end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        int ans=Integer.MAX_VALUE;

        for(int i=start;i<=end;i++){
            ans=Math.min(ans,i+Math.max(solveMem(start,i-1,dp),solveMem(i+1,end,dp)));
        }

        return dp[start][end]=ans;
    }

    public static int solveTab(int n){

        int[][] dp=new int[n+1][n+1];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }

        for(int start=n;start>=1;start--){
            for(int end=start;end<=n;end++){
                if(start==end){
                    continue;
                }
                int ans=Integer.MAX_VALUE;
                for(int i=start;i<end;i++){
                    ans=Math.min(ans,i+Math.max(dp[start][i-1],dp[i+1][end]));
                }
                dp[start][end]=ans;
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount(int n){
        // return solveRec(1,n);
        // int[][] dp=new int[n+1][n+1];
        // for(int[] i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return solveMem(1,n,dp);
        return solveTab(n);
    }
}