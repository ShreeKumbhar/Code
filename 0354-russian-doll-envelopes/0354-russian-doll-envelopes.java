class Solution {

    public static int solve(int[][] arr){

        ArrayList<Integer> list=new ArrayList<>();

        for(int[] n:arr){

            int height=n[1];
            int index=Collections.binarySearch(list,height);

            if(index<0){
                index=-(index+1);
            }
            if(index==list.size()){
                list.add(height);
            }
            else{
                list.set(index,height);
            }
        }
        return list.size();
    }

    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1],a[1]);
        });

        return solve(envelopes);
    }
}