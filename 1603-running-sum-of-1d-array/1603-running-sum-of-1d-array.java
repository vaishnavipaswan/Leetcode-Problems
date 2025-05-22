class Solution {
    public int[] runningSum(int[] nums) {
        int running[]=new int[nums.length];
        running[0]=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            running[i]=sum;
        }
        return running;
    }
}