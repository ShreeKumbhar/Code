class Solution {

    // public static int solveRec(int[] arr,int index,int operation,int k){

    //     if(index==arr.length || operation==2*k){
    //         return 0;
    //     }

    //     int profit=0;
    //     if(operation%2==0){
    //         int buy=-arr[index]+solveRec(arr,index+1,operation+1,k);
    //         int skip=0+solveRec(arr,index+1,operation,k);
    //         profit=Math.max(buy,skip);
    //     }
    //     else{
    //         int sell=arr[index]+solveRec(arr,index+1,operation+1,k);
    //         int skip=0+solveRec(arr,index+1,operation,k);
    //         profit=Math.max(sell,skip);
    //     }

    //     return profit;
    // }

    // Memorization
    public static int solveMem(int[] arr,int index,int operation,int k,int[][] dp){

        if(index==arr.length || operation==2*k){
            return 0;
        }

        if(dp[index][operation]!=-1){
            return dp[index][operation];
        }

        int profit=0;
        if(operation%2==0){
            int buy=-arr[index]+solveMem(arr,index+1,operation+1,k,dp);
            int skip=0+solveMem(arr,index+1,operation,k,dp);
            profit=Math.max(buy,skip);
        }
        else{
            int sell=arr[index]+solveMem(arr,index+1,operation+1,k,dp);
            int skip=0+solveMem(arr,index+1,operation,k,dp);
            profit=Math.max(sell,skip);
        }

        return dp[index][operation]=profit;
    }

    // tabulation
    public static int solveTab(int[] arr,int k){

        int n=arr.length;
        int[][] dp=new int[n+1][k*2+1];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }

        for(int index=n-1;index>=0;index--){
            for(int operation=2*k-1;operation>=0;operation--){
                int profit=0;
                if(operation%2==0){
                    int buy=-arr[index]+dp[index+1][operation+1];
                    int skip=0+dp[index+1][operation];
                    profit=Math.max(buy,skip);
                }
                else{
                    int sell=arr[index]+dp[index+1][operation+1];
                    int skip=0+dp[index+1][operation];
                    profit=Math.max(sell,skip);
                }
                dp[index][operation]=profit;
            }
        }
        return dp[0][0];
    }

    public static int solveSO(int[] arr,int k){

        int n=arr.length;
        int[] curr=new int[2*k+1];
        int[] next=new int[2*k+1];

        for(int index=n-1;index>=0;index--){
            for(int operation=2*k-1;operation>=0;operation--){
                int profit=0;
                if(operation%2==0){
                    int buy=-arr[index]+next[operation+1];
                    int skip=0+next[operation];
                    profit=Math.max(buy,skip);
                }
                else{
                    int sell=arr[index]+next[operation+1];
                    int skip=0+next[operation];
                    profit=Math.max(sell,skip);
                }
                curr[operation]=profit;
            }
            next=curr;
        }
        return next[0];

    }

    public int maxProfit(int k, int[] prices) {
        // return solveRec(prices,0,0,k);
        int n=prices.length;
        // int[][] dp=new int[n][2*k];
        // for(int[] i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return solveMem(prices,0,0,k,dp);

        return solveSO(prices,k);
    }
}