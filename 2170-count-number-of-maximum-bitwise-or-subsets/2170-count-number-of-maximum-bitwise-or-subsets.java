class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max=0;
        for(int n: nums) max|=n;
        return backtrack(nums,max,0,0);
    }
    public int backtrack(int nums[],int max,int idx,int curr){
        if(idx==nums.length){
            if(curr==max) return 1;
            else return 0;
        }
        if(curr==max) return 1<<(nums.length-idx);
        return backtrack(nums,max,idx+1,curr | nums[idx])+backtrack(nums,max,idx+1,curr);
    }
}