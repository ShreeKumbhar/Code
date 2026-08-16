class Solution {
    public int totalFruit(int[] fruits) {
        
        int low = 0;
        int result = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        int n = fruits.length;

        for(int high = 0 ; high<n ; high++){

            map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);
            while( map.size() > 2){
                map.put(fruits[low],map.getOrDefault(fruits[low],0)-1);
                if( map.get(fruits[low])==0 ){
                    map.remove(fruits[low]);
                }
                low++;
            }

            if(map.size()==2 || map.size()<2 ){
                int len = high - low + 1;
                result = Math.max(result,len);
            }
        }
        return result;
    }
}