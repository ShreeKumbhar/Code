class Solution {

    // public static int solveRec(String s1,String s2,int i,int j){

    //     if(i==s1.length() || j==s2.length()){
    //         return 0;
    //     }

    //     int ans=0;

    //     if(s1.charAt(i)==s2.charAt(j)){
    //         ans=1+solveRec(s1,s2,i+1,j+1);
    //     }
    //     else{
    //         ans=Math.max(solveRec(s1,s2,i+1,j),solveRec(s1,s2,i,j+1));
    //     }

    //     return ans;
    // }

    public static int solveTab(String s1,String s2){

        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] i:dp){
            Arrays.fill(i,0);
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
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

    public static int solveSO(String s1,String s2){

        int n=s1.length();
        int m=s2.length();
        int[] curr=new int[m+1];
        int[] next=new int[m+1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans=0;
                if(s1.charAt(i)==s2.charAt(j)){
                    ans=1+next[j+1];
                }
                else{
                    ans=Math.max(next[j],curr[j+1]);
                }
                curr[j]=ans;
            }
            int[] temp=next;
            next=curr;
            curr=temp;
        }
        return next[0];
    }

    public int longestPalindromeSubseq(String s) {
        String reverse=new StringBuilder(s).reverse().toString();
        // return solveRec(s,reverse,0,0);
        return solveSO(s,reverse);
    }
}