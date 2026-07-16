class Solution {

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public long gcdSum(int[] nums) {
        
        int n=nums.length;
        int[] prefixGcd=new int[n];

        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(nums[i],max);
        }

        Arrays.sort(prefixGcd);

        long sum=0;
        int left=0;
        int right=prefixGcd.length-1;

        while(left < right){
            sum+=gcd(prefixGcd[left++],prefixGcd[right--]);
        }

        return sum;
    }
}