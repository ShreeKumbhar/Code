class Solution {

    public static long hourFind(int[] nums,int speed){
        long h = 0;
        for(int i=0; i<nums.length; i++){
            h = h + nums[i] / speed;
            if(nums[i] % speed != 0){
                h++;
            }
        }
        return h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i : piles){
            high = Math.max(high,i);
        }

        int res = -1;

        while( low <= high){

            int mid = low + (high - low)/2;
            long hr = hourFind(piles,mid);
            
            if(hr > h){
                low = mid + 1;
            }
            else{
                res = mid;
                high = mid - 1;
            }
        }

        return res;
    }   
}