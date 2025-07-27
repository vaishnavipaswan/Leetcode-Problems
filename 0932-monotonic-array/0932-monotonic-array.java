class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean high=true;
        boolean low=true;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]) high=false;
            if(nums[i-1]<nums[i]) low=false;
        }
        return high||low;
    }
}