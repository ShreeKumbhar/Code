class Solution {

    public static int findCount(int m,int n,int guess){

        int row = m - 1;
        int col = 0;
        int count = 0;

        while(row>=0 && col < n){
            int value = (row+1) * (col+1);
            if(value <= guess){
                count += row + 1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int res = -1;

        while( low <= high ){

            int guess = low + (high-low)/2;
            int ans = findCount(m,n,guess);

            if(ans < k){
                low = guess + 1;
            }
            else{
                res = guess;
                high = guess - 1;
            }
        }

        return res;
    }
}