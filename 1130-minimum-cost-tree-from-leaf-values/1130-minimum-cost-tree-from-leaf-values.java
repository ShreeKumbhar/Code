class Solution {

    // public static int solveRec(int[] arr,int[][] maxi,int left,int right){

    //     if(left==right){
    //         return 0;
    //     }

    //     int ans=Integer.MAX_VALUE;

    //     for(int i=left;i<right;i++){
    //         ans=Math.min(ans,maxi[left][i]*maxi[i+1][right]+
    //                 solveRec(arr, maxi, left, i)+solveRec(arr, maxi, i+1, right));
    //     }
    //     return ans;
    // }

    // Memorization
    // public static int solveMem(int[][] maxi,int left,int right,int[][] dp){

    //     if(left==right){
    //         return 0;
    //     }

    //     if(dp[left][right]!=-1){
    //         return dp[left][right];
    //     }

    //     int ans=Integer.MAX_VALUE;

    //     for(int i=left;i<right;i++){
    //         ans=Math.min(ans,maxi[left][i]*maxi[i+1][right]+
    //                 solveMem( maxi, left, i,dp)+solveMem( maxi, i+1, right,dp));
    //     }
    //     return dp[left][right]=ans;
    // }

    // Tabulation
    public static int solveTab(int[] arr,int[][] maxi){

        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }

        for(int left=n-2;left>=0;left--){
            for(int right=left+1;right<n;right++){
                int ans=Integer.MAX_VALUE;
                for(int i=left;i<right;i++){
                    ans=Math.min(ans,maxi[left][i]*maxi[i+1][right]+dp[left][i]+dp[i+1][right]);
                }
                dp[left][right]=ans;
            }
        }

        return dp[0][n-1];
    }

    public int mctFromLeafValues(int[] arr) {
        int n= arr.length;
        int[][] maxi=new int[n][n];

        int[][] dp=new int[n+1][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }

        for(int i=0;i<n;i++){
            maxi[i][i]=arr[i];
            for(int j=i+1;j<n;j++){
                maxi[i][j]=Math.max(arr[j],maxi[i][j-1]);
            }
        }

    //    return solveRec(arr,maxi,0,n-1);
    //    return solveMem(maxi,0,n-1,dp);
        return solveTab(arr,maxi);
    }
}