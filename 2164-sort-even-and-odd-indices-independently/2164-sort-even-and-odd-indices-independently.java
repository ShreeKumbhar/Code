class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int n=nums.length;
        int[] even=new int[(n+1)/2];
        int[] odd=new int[n/2];
        int evenNum=0,oddNum=0;

        for(int i=0;i<n;i++){
            if(i%2==0){
                even[evenNum++]=nums[i];
            }
            else{
                odd[oddNum++]=nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);
        int left=0;
        int right=odd.length-1;
        while(left<right){
            int temp=odd[left];
            odd[left]=odd[right];
            odd[right]=temp;
            left++;
            right--;
        }

        evenNum=0;
        oddNum=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                nums[i]=even[evenNum++];
            }
            else{
                nums[i]=odd[oddNum++];
            }
        }

        return nums;
    }
}