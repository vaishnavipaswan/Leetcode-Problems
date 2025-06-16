class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int diff=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min) min=nums[i];
            else if(nums[i]>min) diff=Math.max(diff,nums[i]-min);
        }
        return diff;
    }
}