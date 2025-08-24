class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int count=0;
        int j=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) count++;
            if(count>1){
                if(nums[j]==0){
                    count--;
                }
                j++;
            }
            res=Math.max(res,i-j);
        }
        return res;
    }
}