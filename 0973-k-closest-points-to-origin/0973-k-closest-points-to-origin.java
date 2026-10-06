class Pair{
    int dist;
    int[] pair; 
    Pair(int dist,int[] pair){
        this.dist=dist;
        this.pair=pair;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.dist,a.dist)
        );

        for(int[] point : points){

            int x = point[0];
            int y = point[1];

            int dist = x*x + y*y;

            Pair curr = new Pair(dist,new int[]{x,y});

            pq.offer(curr);

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        for(int i=0; i<k; i++){
            ans[i] = pq.poll().pair;
        }

        return ans;
    }
}