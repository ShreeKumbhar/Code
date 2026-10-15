class Solution {

    public static void solve(int open,int close,int n,List<String> temp,List<String> res){

        if(open==n && close==n){
            res.add(String.join("",temp));
            return;
        }

        if(open < n){
            temp.add("(");
            solve(open+1,close,n,temp,res);
            temp.remove(temp.size()-1);
        }
        if(close < open){
            temp.add(")");
            solve(open,close+1,n,temp,res);
            temp.remove(temp.size()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(0,0,n,temp,res);
        return res;
    }
}