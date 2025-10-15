class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int len=1;
        int prev=0;
        int k=0;
        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)) len++;
            else{
               k=Math.max(k,Math.max(len/2,Math.min(len,prev)));
                prev=len;
                len=1;
            }
        }
        return Math.max(k,Math.max(len/2,Math.min(len,prev)));
    }
}