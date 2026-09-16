class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<int[]> st = new Stack<>();

        for(char ch : s.toCharArray()){

            if(st.isEmpty() || st.peek()[0]!=ch){
                st.push(new int[]{ch,1});
                continue;
            }
            else{
                st.peek()[1]++;
                if(st.peek()[1]==k){
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] p : st){
            while(p[1]-- > 0){
                sb.append((char)p[0]);
            }
        }

        return sb.toString();

    }
}