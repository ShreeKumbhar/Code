class Solution {

    // public static boolean solveRec(int index,int[] nums,int n,int target){

    //     if(index >= n){
    //         return false;
    //     }
    //     if(target==0){
    //         return true;
    //     }
    //     if(target<0){
    //         return false;
    //     }

    //     boolean include= solveRec(index+1,nums,n,target-nums[index]);
    //     boolean exclude= solveRec(index+1,nums,n,target);

    //     return include || exclude;
    // }   

    // public static boolean solveMem(int index,int[] nums,int n,int target,boolean[][] dp){

    //     if(index >= n){
    //         return false;
    //     }
    //     if(target==0){
    //         return true;
    //     }
    //     if(target<0){
    //         return false;
    //     }

    //     if(dp[index][target]!=false){
    //         return dp[index][target];
    //     }

    //     boolean include=solveMem(index+1,nums,n,target-nums[index],dp);
    //     boolean exclude=solveMem(index+1,nums,n,target,dp);

    //     dp[index][target] = include || exclude;
    //     return dp[index][target];
    // }

    public static boolean solveTab(int[] nums,int n,int total){

        boolean[][] dp=new boolean[n+1][(total / 2) + 1];
        for (boolean[] i:dp){
            Arrays.fill(i,false);
        }

        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        for(int index=n-1;index>=0;index--){
            for(int target=1;target<=total/2;target++){
                boolean include=false;
                if(target >= nums[index])
                    include=dp[index+1][target-nums[index]];
                boolean exclude=dp[index+1][target];
                dp[index][target]= include || exclude;
            }
        }
        return dp[0][total/2];
    }

    public static boolean solveSO(int[] nums,int n,int total){

        boolean[] curr=new boolean[(total / 2) + 1];
        boolean[] next=new boolean[(total / 2) + 1];

        curr[0]=true;
        next[0]=true;

        for(int index=n-1;index>=0;index--){
            for(int target=1;target<=total/2;target++){
                boolean include=false;
                if(target >= nums[index])
                    include=next[target-nums[index]];
                boolean exclude=next[target];
                curr[target]= include || exclude;
            }
            boolean[] temp=next;
            next=curr;
            curr=temp;
        }
            return next[total/2];
    }

    public boolean canPartition(int[] nums) {
        int total=0;
        int l=nums.length;
        for(int n:nums){
            total+=n;
        }
        if(total%2!=0){
            return false;
        }
        int target=total/2;
        // return solveRec(0,nums,nums.length,target);
        // boolean[][] dp=new boolean[l][target+1];
        // for(boolean[] i:dp){
        //     Arrays.fill(i,false);
        // }
        // return solveMem(0,nums,l,target,dp);
        return solveSO(nums,l,total);
    }
}