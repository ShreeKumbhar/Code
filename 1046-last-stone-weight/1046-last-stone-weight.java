class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i:stones){
            pq.offer(i);
        }

        while(pq.size() >= 2){

            int x = pq.poll();
            int y = pq.poll();

            if(x==y){
                continue;
            }
            else{
                pq.offer(Math.abs(x-y));
            }
        }

        if(pq.size()==1){
            return pq.peek();
        }
        if(pq.size()==0){
            return 0;
        }

        return 0;
    }
}