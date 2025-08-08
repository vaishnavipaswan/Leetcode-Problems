class Solution {
    double dp[][]=new double[201][201];
    public double soupServings(int n) {
        if(n>4800) return 1.0;
        for(int i=0;i<201;i++){
        Arrays.fill(dp[i],-1);
        }
        int N=(int)Math.ceil(n/25.0);
        return dfs(N,N);
    }
    double dfs(int a,int b){
        if(a<=0 && b>0) return 1;
        if(a<=0 && b<=0) return 0.5;
        if(a>0 && b<=0) return 0;
        if(dp[a][b]!=-1) return dp[a][b];
        double res=0.25*(dfs(a-4,b)+dfs(a-3,b-1)+dfs(a-2,b-2)+dfs(a-1,b-3));
        dp[a][b]=res;
        return res;
        }
}