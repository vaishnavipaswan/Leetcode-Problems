class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int n: nums){
            total+=n;
        }
        if(total%2!=0) return false;
        int target=total/2;
        boolean [] dp=new boolean[target+1];
        dp[0]=true;
        for(int n: nums){
            for(int i=target;i>=n;i--){
                dp[i]=dp[i] || dp[i-n];
                if(dp[target]) return true;
            }
        }
        return dp[target];
    }
}