class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> st = new Stack<>();
        String result = "";

        for(int i=0; i<s.length(); i++){

            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }

            if(s.charAt(i)==st.peek()){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));

        }

        while(!st.isEmpty()){
            result += st.pop();
        }


        return new StringBuilder(result).reverse().toString();
    }
}