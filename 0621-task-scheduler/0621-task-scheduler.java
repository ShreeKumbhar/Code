class Pair{
    int frq;
    char ch;
    Pair(int frq,char ch){
        this.frq=frq;
        this.ch=ch;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,Integer> free = new HashMap<>();

        for(char ch : tasks){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            free.put(ch,1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.frq,a.frq)
        );

        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            char ch = entry.getKey();
            int value = entry.getValue();
            Pair curr = new Pair(value,ch);
            pq.offer(curr);
        }

        int seat = 1;

        while(!pq.isEmpty()){

            ArrayList<Pair> pulled = new ArrayList<>();

            while(!pq.isEmpty()){

                Pair p = pq.poll();
                int frq = p.frq;
                char child = p.ch;

                if(free.get(child) <= seat){
                    free.put(child, seat + n + 1);
                    if(frq > 1){
                        pq.offer(new Pair(frq-1,child));
                    }
                    break;
                }
                else{
                    pulled.add(p);
                }
            }

            pq.addAll(pulled);
            seat++;
        }

        return seat-1;
    }
}