class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
            else{
            continue;
            }
        }
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int t=nums[idx];
                nums[idx]=nums[i];
                nums[i]=t;
                idx++;
            }
        }
        return nums;
    }
}