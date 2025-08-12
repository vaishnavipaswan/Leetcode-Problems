class Solution {
    public static final int MOD=1000000007;
    public int numberOfWays(int n, int x) {
        long dp[]=new long[n+1];
        dp[0]=1;
        for(int i=1;Math.pow(i,x)<=n;i++){
            int power=(int)Math.pow(i,x);
            for(int j=n;j>=power;j--){
                dp[j]=(dp[j]+dp[j-power])%MOD;
            }
        }
        return (int) dp[n];
    }
}