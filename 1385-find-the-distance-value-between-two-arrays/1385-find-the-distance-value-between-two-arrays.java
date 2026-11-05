class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        
        for(int i=0; i<arr1.length; i++){
            boolean isSatisfy = true;
            
            for(int j=0; j<arr2.length; j++){
                int newd = Math.abs(arr1[i] - arr2[j]);
                if(newd <= d){
                    isSatisfy = false;
                    break;
                }

            }
            if(isSatisfy == true){
                cnt++;
            }

        }
        return cnt;

            


        }

        
        
    }