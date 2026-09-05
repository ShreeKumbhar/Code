class Solution {

    public static int square(int n){
        int sum = 0;
        while(n>0){
            int digit = n % 10;
            n /= 10;
            sum += digit*digit;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = n;

        while(fast!=1){
            slow = square(slow);
            fast = square(square(fast));

            if(fast==slow && slow!=1){
                return false;
            }
        }

        return true;
    }
}