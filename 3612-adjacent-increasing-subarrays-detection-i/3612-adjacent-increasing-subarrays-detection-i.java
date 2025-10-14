class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        int len=1;
        int prev=0;
        for(int i=1;i<n && Math.max(len/2,Math.min(len,prev))<k;i++){
            if(nums.get(i)>nums.get(i-1)) len++;
            else{
               // if() return 1;
                prev=len;
                len=1;
            }
        }
        return Math.max(len/2,Math.min(len,prev))>=k;
    }
}