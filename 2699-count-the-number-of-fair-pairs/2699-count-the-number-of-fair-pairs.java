class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return calculate(nums,lower)-calculate(nums,upper+1);
    }
    public long calculate(int nums[],long c){
        int left=0,right=nums.length-1;
        long count=0;
            while(left<right){
                if(nums[left]+nums[right]>=c){
                    count+=left-right;
                    right--;
                }
                else left++;
            }
        return -1*count;
    }
}