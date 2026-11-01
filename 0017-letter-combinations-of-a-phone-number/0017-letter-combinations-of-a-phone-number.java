class Solution {

    public static void solve(String digits,int n,int idx,List<String> diary,List<String> res,
    HashMap<Character,String> map){

        if(idx == n){
            res.add(String.join("",diary));
            return ;
        }

        String choice = map.get(digits.charAt(idx));

        for(int i=0; i<choice.length(); i++){
            diary.add(String.valueOf(choice.charAt(i)));
            solve(digits,n,idx+1,diary,res,map);
            diary.remove(diary.size()-1);
        }

        return;
    }

    public List<String> letterCombinations(String digits) {
        
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> diary = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int n = digits.length();
        int idx = 0;
        solve(digits,n,idx,diary,res,map);
        return res;
    }
}