class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        for(int j=n-1;j>0;j--){
            for(int i=0;i<n-1;i++){
                nums[i]=(nums[i]+nums[i+1])%10;
            }
        }
        int res=nums[0];
        return res;
    }
}