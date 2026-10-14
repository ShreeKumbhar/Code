class Solution {

    public static void solve(String s,int idx,List<String> temp,List<String> ans){

        if(idx==s.length()){
            ans.add(String.join("",temp));
            return ;
        }

        char ch = s.charAt(idx);

        if(Character.isDigit(ch)){
            temp.add(String.valueOf(ch));
            solve(s,idx+1,temp,ans);
            temp.remove(temp.size()-1);
            return ;
        }

        //lower
        temp.add(String.valueOf(Character.toLowerCase(ch)));
        solve(s,idx+1,temp,ans);
        temp.remove(temp.size()-1);

        //Upper
        temp.add(String.valueOf(Character.toUpperCase(ch)));
        solve(s,idx+1,temp,ans);
        temp.remove(temp.size()-1);

    }

    public List<String> letterCasePermutation(String s) {
        List<String> temp = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(s,0,temp,ans);
        return ans;
    }
}