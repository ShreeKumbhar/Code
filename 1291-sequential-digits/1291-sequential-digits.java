class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        String str="123456789";

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for(int i=lowLen;i<=highLen;i++){
            for(int j=0;j+i<=9;j++){
                int num = Integer.parseInt(str.substring(j,j+i));
                if(num>=low && num<=high){
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}