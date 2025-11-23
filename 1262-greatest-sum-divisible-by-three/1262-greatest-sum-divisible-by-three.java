class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[]=new int[3];
        for(int i:nums){
            int curr[]=dp.clone();
            for(int s:curr){
                int sum=s+i;
                int rem=sum%3;
                dp[rem]=Math.max(dp[rem],sum);
            }
        }
        return dp[0];
    }
}