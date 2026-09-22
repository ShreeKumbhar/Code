class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character,Integer> ransom = new HashMap<>();
        HashMap<Character,Integer> mag = new HashMap<>();

        for( char ch : ransomNote.toCharArray()){
            ransom.put(ch,ransom.getOrDefault(ch,0)+1);
        }

        for( char ch : magazine.toCharArray()){
            mag.put(ch,mag.getOrDefault(ch,0)+1);
        }


        for( char ch : ransom.keySet()){
            if( mag.getOrDefault(ch,0) < ransom.get(ch)){
                return false;
            }
        }

        return true;

    }
}