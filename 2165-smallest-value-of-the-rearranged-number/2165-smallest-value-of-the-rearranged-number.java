class Solution {
    public long smallestNumber(long num) {
        
        boolean n=num<0;

        char[] digit=String.valueOf(Math.abs(num)).toCharArray();
        Arrays.sort(digit);

        if(!n){
            if(digit[0]=='0'){
                for(int i=1;i<digit.length;i++){
                    if(digit[i]!='0'){
                        char temp=digit[0];
                        digit[0]=digit[i];
                        digit[i]=temp;
                        break;
                    }
                }
            }
            return Long.parseLong(new String(digit));
        }
        else{
            int left=0;
            int right=digit.length-1;
            while(left<right){
                char temp=digit[left];
                digit[left]=digit[right];
                digit[right]=temp;
                left++;
                right--;
            }
            return -Long.parseLong(new String(digit));
        }
    }   
}