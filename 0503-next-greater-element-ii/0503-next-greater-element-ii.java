class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i=n-2; i>=0; i--){
            st.push(nums[i]);
        }

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return result;
    }
}