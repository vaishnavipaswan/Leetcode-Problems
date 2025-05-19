class Solution {
    public int[] sortedSquares(int[] nums) {
        int res[]=new int[nums.length];
        int r=nums.length-1;
        int l=0;
        int pos=res.length-1;
        while(l<=r){
            if(Math.abs(nums[l])>Math.abs(nums[r])) {
                res[pos]=nums[l]*nums[l];
                l++;
            }
            else {
                res[pos]=nums[r]*nums[r];
                r--;
            }
            pos--;
        }
        return res;
    }
}