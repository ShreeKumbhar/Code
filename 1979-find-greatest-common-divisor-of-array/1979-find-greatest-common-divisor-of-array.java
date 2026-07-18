class Solution {

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public int findGCD(int[] nums) {
        
        int large=Integer.MIN_VALUE;
        int small=Integer.MAX_VALUE;

        for(int i:nums){
            large=Math.max(large,i);
            small=Math.min(small,i);
        }

        return gcd(large,small);
    }
}