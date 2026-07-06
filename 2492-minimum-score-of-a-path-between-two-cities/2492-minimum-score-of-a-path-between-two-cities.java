class Solution {

    public static int dfs(int node,ArrayList<int[]>[] adj,boolean[] visited){

        visited[node]=true;
        int ans=Integer.MAX_VALUE;

        for(int[] neighbour:adj[node]){
            ans=Math.min(ans,neighbour[1]);
            if(!visited[neighbour[0]]){
                ans = Math.min(ans, dfs(neighbour[0], adj, visited));
            }
        }
        return ans;
    }

    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] adj=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] road:roads){
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }

        boolean[] visited=new boolean[n+1];

        return dfs(1,adj,visited);
    }
}