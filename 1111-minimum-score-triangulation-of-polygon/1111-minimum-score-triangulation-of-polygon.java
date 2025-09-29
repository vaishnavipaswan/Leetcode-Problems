class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int dp[][]=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                for(int k=i+1;k<j;k++){
                    if(dp[i][j]==0) dp[i][j]=Math.min(Integer.MAX_VALUE,dp[i][k]+ values[i]*values[k]*values[j]+dp[k][j]);
                    else dp[i][j]=Math.min(dp[i][j],dp[i][k]+ values[i]*values[k]*values[j]+dp[k][j]);
               }
            }
        }
        return dp[0][n-1];
    }
}