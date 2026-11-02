class Solution {

    public static void solve(int[] arr,int n,int idx,List<Integer> diary,List<List<Integer>> res,int sum,int target){

        if(idx == n){
            if(sum == target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }

        solve(arr,n,idx+1,diary,res,sum,target);

        if( arr[idx]+sum <= target){
            diary.add(arr[idx]);
            sum += arr[idx];
            solve(arr,n,idx,diary,res,sum,target);
            diary.remove(diary.size()-1);
            sum -= arr[idx];
        }

        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        int idx = 0;
        int n = candidates.length;
        int sum = 0;
        solve(candidates,n,idx,diary,res,sum,target);
        return res;

    }
}