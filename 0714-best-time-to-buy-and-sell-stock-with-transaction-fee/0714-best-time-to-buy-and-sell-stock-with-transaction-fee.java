class Solution {

    // public static int solveRec(int[] arr,int index,int buy,int fee){

    //     if(index==arr.length){
    //         return 0;
    //     }

    //     int profit=0;
    //     if(buy==1){
    //         int buyStock = -arr[index] + solveRec(arr,index+1,0,fee);
    //         int skip = 0 + solveRec(arr,index+1,1,fee);
    //         profit=Math.max(buyStock,skip);
    //     }
    //     else{
    //         int sell = arr[index] + solveRec(arr,index+1,1,fee) - fee;
    //         int skip = 0 + solveRec(arr,index+1,0,fee);
    //         profit=Math.max(sell,skip);
    //     }
    //     return profit;
    // }

    // Memorization
    public static int solveMem(int[]arr,int index,int buy,int n,int[][] dp,int fee){
        if(index==n){
            return 0;
        }

        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }

        int profit=0;
        if(buy==1){
            // buy
            int buyStock = -arr[index] + solveMem(arr,index+1,0,n,dp,fee);
            int skip = 0 + solveMem(arr, index+1, 1, n,dp,fee);
            profit=Math.max(buyStock,skip);
        }
        else{
            //sell
            int sell = arr[index] + solveMem(arr, index+1, 1, n,dp,fee)-fee;
            int skip = 0 + solveMem(arr, index+1, 0, n,dp,fee);
            profit=Math.max(sell,skip);
        }

        return dp[index][buy]=profit;
    }

    // Tabulation
    public static int solveTab(int[]arr,int fee){

        int n= arr.length;
        int[][] dp=new int[n+1][2];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }

        dp[n][0]=0;
        dp[n][1]=0;

        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    // buy
                    int buyStock = -arr[index] + dp[index+1][0];
                    int skip = 0 + dp[ index+1][1];
                    profit=Math.max(buyStock,skip);
                }
                // sell
                else{
                    //sell
                    int sell = arr[index] + dp[index+1][1]-fee;
                    int skip = 0 + dp[index+1][0];
                    profit=Math.max(sell,skip);
                }
                dp[index][buy]=profit;
            }
        }

        return dp[0][1];
    }

    // Space optimization
    public static int solveSO(int[] arr,int fee){

        int n= arr.length;

        int[] curr=new int[2];
        int[] next=new int[2];
        Arrays.fill(curr,0);
        Arrays.fill(next,0);

        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                // buy the stock
                if(buy==1){
                    // buy
                    int buyStock = -arr[index] + next[0];
                    int skip = 0 + next[1];
                    profit=Math.max(buyStock,skip);
                }
                // sell
                else{
                    //sell
                    int sell = arr[index] + next[1]-fee;
                    int skip = 0 + next[0];
                    profit=Math.max(sell,skip);
                }
                curr[buy]=profit;
            }
            int[] temp=next;
            next=curr;
            curr=temp;
        }
        return next[1];
    }

    public int maxProfit(int[] prices, int fee) {
        // return solveRec(prices,0,1,fee);
        int n= prices.length;
       //int[][] dp = new int[n][2];

    //    for (int i = 0; i < n; i++) {
    //        Arrays.fill(dp[i], -1);
    //    }
    //    return solveMem(prices,0,1,n,dp,fee);
        // return solveTab(prices,fee);
        return solveSO(prices,fee);
    }
}