class Solution {

    // Recurssion
    // public static int solveRec(int[] arr,int index,int buy,int limit){

    //     if(index==arr.length){
    //         return 0;
    //     }
    //     if(limit==0){
    //         return 0;
    //     }

    //     int profit=0;

    //     if(buy==1){
    //         int buyStock = -arr[index] + solveRec(arr,index+1,0,limit);
    //         int skip = 0 + solveRec(arr,index+1,1,limit);
    //         profit=Math.max(buyStock,skip);
    //     }
    //     else{
    //         int sell = arr[index] + solveRec(arr,index+1,1,limit-1);
    //         int skip = 0 + solveRec(arr,index+1,0,limit);
    //         profit=Math.max(sell,skip);
    //     }
    //     return profit;
    // }

    // Memorization
    // public static int solveMem(int[]arr,int index,int buy,int limit,int[][][] dp){
    //     if(index==arr.length){
    //         return 0;
    //     }

    //     if(limit==0){
    //         return 0;
    //     }

    //     if(dp[index][buy][limit]!=-1){
    //         return dp[index][buy][limit];
    //     }

    //     int profit=0;
    //     // buy the stock
    //     if(buy==1){
    //         // buy
    //         int buyStock = -arr[index] + solveMem(arr,index+1,0, limit,dp);
    //         int skip = 0 + solveMem(arr, index+1, 1, limit ,dp);
    //         profit=Math.max(buyStock,skip);
    //     }
    //     // sell
    //     else{
    //         //sell
    //         int sell = arr[index] + solveMem(arr, index+1, 1, limit-1, dp);
    //         int skip = 0 + solveMem(arr, index+1, 0, limit, dp);
    //         profit=Math.max(sell,skip);
    //     }

    //     return dp[index][buy][limit]=profit;
    // }

    // Tabulation
    public static int solveTab(int[]arr){

        int n= arr.length;
        int[][][] dp=new int[n+1][2][3];

        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                for(int limit=0;limit<2;limit++){
                    int profit=0;
                    // buy the stock
                    if(buy==1){
                        // buy
                        int buyStock = -arr[index] + dp[index+1][0][limit];
                        int skip = 0 + dp[index+1][1][limit];
                        profit=Math.max(buyStock,skip);
                    }
                    // sell
                    else{
                        //sell
                        int sell = arr[index] + dp[index+1][1][limit+1];
                        int skip = 0 + dp[index+1][0][limit];
                        profit=Math.max(sell,skip);
                    }
                    dp[index][buy][limit]=profit;
                }
            }
        }

        return dp[0][1][0];
    }

    public int maxProfit(int[] prices) {
        // return solveRec(prices,0,1,2);
        // int n=prices.length;
        // int[][][] dp = new int[n][2][3];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return solveMem(prices,0,1,2,dp);

        return solveTab(prices);
    }
}