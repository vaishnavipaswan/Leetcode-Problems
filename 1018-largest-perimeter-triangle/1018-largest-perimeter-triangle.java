class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]<nums[i-1]+nums[i-2]){
                res=nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return res;
    }
}