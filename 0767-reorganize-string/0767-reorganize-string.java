class Pair{
    int freq;
    char letter;
    Pair(int freq,char letter){
        this.freq=freq;
        this.letter=letter;
    }
}

class Solution {
    public String reorganizeString(String s) {
        
        StringBuilder res = new StringBuilder();

        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq!=b.freq){
                    return Integer.compare(b.freq,a.freq);
                }
                return Character.compare(a.letter,b.letter);
            }
        );

        for(Map.Entry<Character, Integer> entry : map.entrySet()){

            char ch = entry.getKey();
            int freq = entry.getValue();

            Pair curr = new Pair(freq,ch);

            pq.offer(curr);
        }

        int seat=0;

        while(!pq.isEmpty()){

            Pair p = pq.poll();
            if(seat==0 || res.charAt(seat-1)!=p.letter){
                res.append(p.letter);
                seat++;
                p.freq--;
                if(p.freq > 0){
                    pq.offer(p);
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                Pair p2 = pq.poll();
                res.append(p2.letter);
                seat++;
                p2.freq--;
                if(p2.freq > 0){
                    pq.offer(p2);
                }
                pq.offer(p);
            }
        }

        return res.toString();
    }
}