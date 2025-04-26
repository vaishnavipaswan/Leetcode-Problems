class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        int min=-1;
        int max=-1;
        int start=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK)start=i;
            if(nums[i]==minK)min=i;
            if(nums[i]==maxK)max=i;
            int valid=Math.max(0,Math.min(max,min)-start);
            count+=valid;
        }
        return count;
    }
}