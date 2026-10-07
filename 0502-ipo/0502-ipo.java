class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        ArrayList<Pair> proj = new ArrayList<>();

        for(int i=0; i<profits.length; i++){
            proj.add(new Pair(capital[i],profits[i]));
        }

        proj.sort((a,b) -> Integer.compare(a.first, b.first));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx=0;

        while(k-- > 0){

            while(idx < profits.length){
                if(proj.get(idx).first > w){
                    break;
                }
                pq.offer(proj.get(idx).second);
                idx++;
            }

            if(pq.isEmpty()){
                return w;
            }

            w = w + pq.poll();
        }

        return w;
    }
}