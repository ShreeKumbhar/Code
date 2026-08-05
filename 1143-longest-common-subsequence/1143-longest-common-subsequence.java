class Solution {

    public static int solveRec(String s1, String s2,int i,int j){

        if(i==s1.length() || j==s2.length()){
            return 0;
        }

        int ans=0;

        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+solveRec(s1,s2,i+1,j+1);
        }
        else{
            ans=Math.max(solveRec(s1,s2,i+1,j),solveRec(s1,s2,i,j+1));
        }

        return ans;
    }

    // Memorizationw
    public static int solveMem(String s1,String s2,int i,int j,int[][] dp){

        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+solveMem(s1,s2,i+1,j+1, dp);
        }
        else{
            ans=Math.max(solveMem(s1,s2,i+1,j, dp),solveMem(s1,s2,i,j+1, dp));
        }
        return dp[i][j]=ans;
    }

    // Tabulation
    public static int solveTab(String s1,String s2){

        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }

        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                int ans=0;
                if(s1.charAt(i)==s2.charAt(j)){
                    ans=1+dp[i+1][j+1];
                }
                else{
                    ans=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // return solveRec(text1,text2,0,0);
        // int[][] dp=new int[text1.length()][text2.length()];
        // for(int[] i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return solveMem(text1,text2,0,0,dp);
        return solveTab(text1,text2);
    }
}