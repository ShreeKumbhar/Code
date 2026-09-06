class Solution {
    public int maximumSum(int[] arr) {
        
        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int result = arr[0];

        for( int i=1 ; i<arr.length ; i++){

            int prevNoDel = noDelete;
            int prevOneDel = oneDelete;

            noDelete = Math.max(noDelete+arr[i],arr[i]);

            int v2;
            if(prevOneDel == Integer.MIN_VALUE){
                v2 = Integer.MIN_VALUE;
            }
            else{
                v2 = prevOneDel + arr[i];
            }

            oneDelete = Math.max(v2,prevNoDel);
            result = Math.max(result,Math.max(noDelete,oneDelete));
        }

        return result;
    }
}