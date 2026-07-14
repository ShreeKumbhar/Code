class Solution {
    public String compressedString(String word) {

        int i=0;
        StringBuilder sb = new StringBuilder();

        while(i < word.length()){

            int count=0;
            char ch=word.charAt(i);

            while(i<word.length() && word.charAt(i)==ch && count<9){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(ch);
        }

        return sb.toString();
    }
}