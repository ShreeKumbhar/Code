class Solution {

    // public static int solveRec(int[][] grid,int row,int col){

        // if(row>=grid.length || col>=grid[0].length){
        //     return Integer.MAX_VALUE;
        // }

        // if(row==grid.length-1 && col==grid[0].length-1){
        //     return grid[row][col];
        // }

        // int right=solveRec(grid,row,col+1);
        // int down=solveRec(grid,row+1,col);

        // // if(right==Integer.MAX_VALUE && down==Integer.MAX_VALUE){
        // //     return Integer.MAX_VALUE;
        // // }

        // int ans=grid[row][col] + Math.min(right,down);

        // return ans;
    // }

    public static int solveMem(int[][] grid,int row,int col,int[][] dp){

        if(row>=grid.length || col>=grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int right=solveMem(grid,row,col+1,dp);
        int down=solveMem(grid,row+1,col,dp);

        dp[row][col] = grid[row][col] + Math.min(right,down);

        return dp[row][col];
    }

    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row][col];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solveMem(grid,0,0,dp);
    }
}