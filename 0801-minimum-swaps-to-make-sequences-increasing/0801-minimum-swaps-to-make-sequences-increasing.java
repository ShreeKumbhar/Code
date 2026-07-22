class Solution {

    // public static int solveRec(int[] nums1, int[] nums2,int index,boolean swapped){

    //     if(index==nums1.length){
    //         return 0;
    //     }

    //     int ans=Integer.MAX_VALUE;

    //     int prev1=nums1[index-1];
    //     int prev2=nums2[index-1];

    //     if(swapped){
    //         int temp=prev1;
    //         prev1=prev2;
    //         prev2=temp;
    //     }

    //     if(nums1[index]>prev1 && nums2[index]>prev2){
    //         ans=solveRec(nums1,nums2,index+1,false);
    //     }

    //     if(nums1[index]>prev2 && nums2[index]>prev1){
    //         ans=Math.min(ans,1+solveRec(nums1,nums2,index+1,true));
    //     }
        
    //     return ans;
    // }

    // public static int solveMem(int[]nums1,int[] nums2,int index,boolean swapped,int[][] dp){

    //     if(index==nums1.length){
    //         return 0;
    //     }

    //     int swapState=swapped?1:0;

    //     if(dp[index][swapState]!=-1){
    //         return dp[index][swapState];
    //     }

    //     int ans=Integer.MAX_VALUE;
    //     int prev1=nums1[index-1];
    //     int prev2=nums2[index-1];

    //     if(swapped){
    //         int temp=prev1;
    //         prev1=prev2;
    //         prev2=temp;
    //     }

    //     if(nums1[index]>prev1 && nums2[index]>prev2){
    //         ans=solveMem(nums1,nums2,index+1,false,dp);
    //     }

    //     if(nums1[index]>prev2 && nums2[index]>prev1){
    //         ans=Math.min(ans,1+solveMem(nums1,nums2,index+1,true,dp));
    //     }

    //     dp[index][swapState]=ans;
    //     return dp[index][swapState];
    // }

    public static int solveSO(int[]nums1,int[] nums2){

        int noSwap = 0;
        int swap = 1;

        for (int index = 1; index < nums1.length; index++) {

            int currNoSwap = Integer.MAX_VALUE;
            int currSwap = Integer.MAX_VALUE;

            if (nums1[index] > nums1[index - 1] &&
                nums2[index] > nums2[index - 1]) {
                currNoSwap = Math.min(currNoSwap,noSwap);
                currSwap = Math.min(currSwap,swap + 1);
            }
            if (nums1[index] > nums2[index - 1] &&
                nums2[index] > nums1[index - 1]) {
                currNoSwap = Math.min(currNoSwap,swap);
                currSwap = Math.min(currSwap,noSwap + 1);
            }
            noSwap = currNoSwap;
            swap = currSwap;
        }
        return Math.min(noSwap, swap);
    }


    public int minSwap(int[] nums1, int[] nums2) {
        // boolean swapped=false;
        // return solveRec(nums1,nums2,1,swapped);
        // int n=nums1.length;
        // int[][] dp=new int[n][2];
        // for(int[] i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return solveMem(nums1,nums2,1,swapped,dp);

        return solveSO(nums1,nums2);
    }
}