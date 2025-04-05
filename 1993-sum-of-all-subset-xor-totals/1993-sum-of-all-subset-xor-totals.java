class Solution {
    public int subsetXORSum(int[] nums) {
        int res=xorSum(nums,0,0);
        return res;
    }
    public int xorSum(int[] nums,int idx,int xorSum){
        if(nums.length==idx) return xorSum;
        int inc=xorSum(nums,idx+1,xorSum^nums[idx]);
        int exc=xorSum(nums,idx+1,xorSum);
        return inc+exc;
    }
}
