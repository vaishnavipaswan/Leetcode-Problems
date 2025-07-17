class Solution {
    public int maximumLength(int[] nums, int k) {
        Map<Integer,Integer>[] dp=new HashMap[nums.length];
        int max=1;
        for(int i=0;i<nums.length;i++) dp[i]=new HashMap<>();
        for(int i=0;i<nums.length;i++){
             for(int j=0;j<i;j++){
                    int mod=(nums[i]+nums[j])%k;
                    int len=dp[j].getOrDefault(mod,1)+1;
                    dp[i].put(mod,Math.max(dp[i].getOrDefault(mod,1),len));
                    max=Math.max(max,dp[i].get(mod));
                }
            }
       return max;
    }
}