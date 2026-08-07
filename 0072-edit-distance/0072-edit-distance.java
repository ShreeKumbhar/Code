class Solution {

    // public static int solveRec(String s1,String s2,int i,int j){

    //     if(i==s1.length()){
    //         return s2.length()-j;
    //     }
    //     if(j==s2.length()){
    //         return s1.length()-i;
    //     }

    //     int ans=0;
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return solveRec(s1,s2,i+1,j+1);
    //     }
    //     else{
    //         int insert=1+solveRec(s1,s2,i,j+1);
    //         int delete=1+solveRec(s1,s2,i+1,j);
    //         int replace=1+solveRec(s1,s2,i+1,j+1);
    //         ans=Math.min(insert,Math.min(delete,replace));
    //     }
    //     return ans;
    // }

    // public static int solveMem(String s1,String s2,int i,int j,int[][] dp){

    //     if(i==s1.length()){
    //         return s2.length()-j;
    //     }
    //     if(j==s2.length()){
    //         return s1.length()-i;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }

    //     int ans=0;
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return solveMem(s1,s2,i+1,j+1,dp);
    //     }
    //     else{
    //         int insert=1+solveMem(s1,s2,i,j+1,dp);
    //         int delete=1+solveMem(s1,s2,i+1,j,dp);
    //         int replace=1+solveMem(s1,s2,i+1,j+1,dp);
    //         ans=Math.min(insert,Math.min(delete,replace));
    //     }
    //     return dp[i][j]=ans;
    // }

    public static int solveTab(String s1,String s2){

        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }

        for(int j=0;j<s2.length();j++){
            dp[s1.length()][j]=s2.length()-j;
        }
        for(int i=0;i<s1.length();i++){
            dp[i][s2.length()]=s1.length()-i;
        }

        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                int ans=0;
                if(s1.charAt(i)==s2.charAt(j)){
                    ans=dp[i+1][j+1];
                }
                else{
                    int insert=1+dp[i][j+1];
                    int delete=1+dp[i+1][j];
                    int replace=1+dp[i+1][j+1];
                    ans=Math.min(insert,Math.min(delete,replace));
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }

    public int minDistance(String word1, String word2) {
        // return solveRec(word1,word2,0,0);
        // int[][] dp=new int[word1.length()][word2.length()];
        // for(int[] i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return solveMem(word1,word2,0,0,dp);
        return solveTab(word1,word2);

    }
}