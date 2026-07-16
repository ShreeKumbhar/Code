class Solution {

    // public static int solve(int[] slices,int index,int endIndex,int n){

    //     if (n == 0)
    //         return 0;

    //     if (index > endIndex)
    //         return 0;

    //     int take=slices[index] + solve(slices, index + 2, endIndex, n - 1);
    //     int notTake= 0 + solve(slices,index+1,endIndex,n);

    //     return Math.max(take,notTake);

    // }

    public static int solveTab(int[] slices){

        int k=slices.length;
        int[][] dp1=new int[k+2][k+2];
        int[][] dp2=new int[k+2][k+2];

        //1 case
        for(int index=k-2;index>=0;index--){
            for(int n=1;n<=k/3;n++){
                int take = slices[index] + dp1[index+2][n-1];
                int notTake= 0 + dp1[index+1][n];
                dp1[index][n] = Math.max(take,notTake);
            }
        }
        int case1=dp1[0][k/3];

        //2 case
        for(int index=k-1;index>=1;index--){
            for(int n=1;n<=k/3;n++){
                int take = slices[index] + dp2[index+2][n-1];
                int notTake= 0 + dp2[index+1][n];
                dp2[index][n] = Math.max(take,notTake);
            }
        }
        int case2=dp2[1][k/3];

        return Math.max(case1,case2);
    }

    public int maxSizeSlices(int[] slices) {

        // int k=slices.length;
        // int case1=solve(slices,0,k-2,k/3);
        // int case2=solve(slices,1,k-1,k/3);
        // return Math.max(case1,case2);
        return solveTab(slices);
    }
}