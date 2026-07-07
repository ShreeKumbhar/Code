class Solution {
    public long sumAndMultiply(int n) {
        
        if(n==0){
            return 0;
        }

        String str=String.valueOf(n);
        StringBuilder sb=new StringBuilder();
        int sum=0;

        for(char ch:str.toCharArray()){
            if(ch!='0'){
                sb.append(ch);
                sum+=ch-'0';
            }
        }

        long x=0;
        if(sb.length()>0){
            x=Long.parseLong(sb.toString());
        }

        return sum*x;
    }
}