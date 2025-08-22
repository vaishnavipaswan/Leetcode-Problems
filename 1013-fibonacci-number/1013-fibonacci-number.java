class Solution {
    public int fib(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++) dp[i]=-1;
        if(n==1||n==0) return n;
        dp[n]=fib(n-1)+fib(n-2);
        return dp[n];
    }
}