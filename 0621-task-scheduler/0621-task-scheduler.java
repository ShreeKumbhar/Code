class Pair{
    int freq;
    char letter;
    Pair(int freq,char letter){
        this.freq=freq;
        this.letter=letter;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int time = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.freq, a.freq)
        );

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            Pair curr = new Pair(freq,ch);
            pq.offer(curr);
        }

        while(!pq.isEmpty()){
            ArrayList<Pair> temp = new ArrayList<>();
            int used=0;
            int cycle = n+1;
            for(int i=0; i<cycle; i++){
                if(!pq.isEmpty()){
                    Pair p = pq.poll();
                    p.freq--;
                    temp.add(p);
                    used++;
                }
            }

            for(Pair curr : temp){
                if(curr.freq > 0){
                    pq.offer(curr);
                }
            }

            if (!pq.isEmpty()) {
                time += cycle;   
            } else {
                time += used; 
            }
        }

        return time;
    }
}