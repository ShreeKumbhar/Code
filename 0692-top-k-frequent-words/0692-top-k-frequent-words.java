class Pair{
    int freq;
    String word;
    Pair(int freq,String word){
        this.freq = freq;
        this.word = word;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq!=b.freq){
                    return Integer.compare(a.freq,b.freq);
                }
                return b.word.compareTo(a.word);
            }
        );
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String i : words){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){

            String w = entry.getKey();
            int freq = entry.getValue();

            Pair curr = new Pair(freq,w);

            pq.offer(curr);

            if(pq.size() > k){
                pq.poll();
            }
        }

        LinkedList<String> ans = new LinkedList<>();

        while (!pq.isEmpty()) {
            ans.addFirst(pq.poll().word);
        }

        return ans;
    }
}