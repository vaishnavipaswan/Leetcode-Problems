class Solution {
    public int longestSubarray(int[] nums) {
        int max=Integer.MIN_VALUE;
       for(int i: nums){
        if(i>max) max=i;
       }
        int consec=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                consec++;
            }
            else consec=0;
            if(consec>res) res=consec;
        }
        return res;
    }
}