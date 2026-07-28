class Solution {
    public String smallestPalindrome(String s) {
        
        int length=s.length();
        int mid=length/2;

        char[] ch=s.toCharArray();

        Arrays.sort(ch,0,mid);

        for(int i=0;i<mid;i++){
            ch[length-i-1]=ch[i];
        }

        return new String(ch);
        
    }
}