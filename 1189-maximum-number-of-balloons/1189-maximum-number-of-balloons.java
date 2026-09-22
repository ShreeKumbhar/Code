class Solution {
    public int maxNumberOfBalloons(String text) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : text.toCharArray()){
            if( ch=='b' || ch=='a' || ch=='l' || ch=='o' || ch=='n' ){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }

        int singleLetter = Math.min(map.getOrDefault('b',0),Math.min(map.getOrDefault('a',0),map.getOrDefault('n',0)));
        int doubleLetter = Math.min(map.getOrDefault('l',0),map.getOrDefault('o',0));

        return Math.min(singleLetter,doubleLetter/2);
    }
}