class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> rowAns = new ArrayList<>();

        for(int i=0; i<=rowIndex; i++){

            List<Integer> ans = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    ans.add(1);
                }
                else{
                    int res = rowAns.get(i-1).get(j-1) + rowAns.get(i-1).get(j);
                    ans.add(res);
                }
            }
            rowAns.add(ans);
        }

        return rowAns.get(rowIndex);
    }
}