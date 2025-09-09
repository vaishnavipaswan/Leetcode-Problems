class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[]=new long[n+1];
        dp[1]=1;
        long s=0;
        long MOD=(long)1000000007;
        for(int i=2;i<=n;i++){
            if(i-delay>0) s=(s+dp[i-delay]+MOD)% MOD;
            if(i-forget>0) s=(s-dp[i-forget]+MOD)% MOD;
            dp[i]=s;
        }
        long res=0;
        for(int i=n-forget+1;i<=n;i++) res=(res+dp[i])%MOD;
        return (int) res;
    }
}