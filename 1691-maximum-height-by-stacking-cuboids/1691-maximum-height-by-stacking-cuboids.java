class Solution {

    static boolean check(int[] curr,int[] prev){
        return curr[0]>=prev[0] && curr[1]>=prev[1] && curr[2]>=prev[2];
    }

    static int solveTab(int n,int[][] cuboids){

        int[] currRow=new int[n+1];
        int[] nextRow=new int[n+1];

        for(int curr=n-1;curr>=0;curr--){
            Arrays.fill(currRow,0);
            for(int prev=curr-1;prev>=-1;prev--){
                int take=0;
                if(prev==-1 || check(cuboids[curr],cuboids[prev])){
                    take=cuboids[curr][2]+nextRow[curr+1];
                }
                int notTake=nextRow[prev+1];
                currRow[prev+1]=Math.max(take,notTake);
            }
            int[] temp=nextRow;
            nextRow=currRow;
            currRow=temp;
        }

        return nextRow[0];
    }

    public int maxHeight(int[][] cuboids) {
        
        for(int[] i:cuboids){
            Arrays.sort(i);
        }
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        return solveTab(cuboids.length,cuboids);

    }
}