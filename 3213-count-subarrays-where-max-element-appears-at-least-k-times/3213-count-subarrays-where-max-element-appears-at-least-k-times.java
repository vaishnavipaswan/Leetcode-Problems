class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for(int i: nums) max=Math.max(max,i);
        int l=0;
        long maxOccur=0;
        long res=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==max) maxOccur++;
            while(maxOccur>=k){
                if(nums[l]==max)maxOccur--;
                l++;
            }
            res+=l;
        }
        return res;
    }
}