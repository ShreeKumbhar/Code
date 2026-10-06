class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a.first!=b.first){
                    return Integer.compare(a.first,b.first);
                }
                return Integer.compare(a.second,b.second);
            }
        );

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            int element = entry.getKey();
            int freq = entry.getValue();

            Pair curr = new Pair(freq, element);

            if(pq.size() < k){
                pq.offer(curr);
                continue;
            }

            if(freq > pq.peek().first){
                pq.poll();
                pq.offer(curr);
            }
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = pq.poll().second;
        }

        return ans;
    }
}