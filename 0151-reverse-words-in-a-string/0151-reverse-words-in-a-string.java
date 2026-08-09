class Solution {
    public String reverseWords(String s) {
        String[] part=s.split(" ");
        List<String> str=new ArrayList<>();

        for(String string:part){
            if(!string.isEmpty()){
                str.add(string);
            }
        }

        Collections.reverse(str);

        return String.join(" ",str);
    }
}