class Solution {
    public int maxFrequency(int[] nums,int k){
        Arrays.sort(nums);
        int l=0,res=0;
        long curr=0;
        for(int r=0;r<nums.length;r++){
            long t=nums[r];
            curr+=t;
            
            while((r-l+1)*t-curr>k){
                curr-=nums[l];
                l++;
            }
            
            res=Math.max(res,r-l+1);
        }
        
        return res;
    }
}