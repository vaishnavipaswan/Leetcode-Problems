class Solution {
    public int numSubmat(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int res=0;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dp[i][j]=0;
                }
                else if(j==0){
                        dp[i][j]=1;
                      }
                else{
                        dp[i][j]=dp[i][j-1]+1;
                    }
                int temp=dp[i][j];
                for(int k=i;k>=0;k--){
                    temp=Math.min(temp,dp[k][j]);
                    if(temp==0) break;
                    res+=temp;
                }
            }
        }
        return res;
    }
}