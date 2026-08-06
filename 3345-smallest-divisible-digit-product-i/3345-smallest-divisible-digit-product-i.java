class Solution {

    public static int digitP(int n){
        int product=1;
        while(n>0){
            int digit=n%10;
            product*=digit;
            n=n/10;
        }
        return product;
    }

    public int smallestNumber(int n, int t) {
        
        int num=n;
        while(true){
            int product=digitP(num);
            if(product%t==0){
                return num;
            }
            num++;
        }
    }
}