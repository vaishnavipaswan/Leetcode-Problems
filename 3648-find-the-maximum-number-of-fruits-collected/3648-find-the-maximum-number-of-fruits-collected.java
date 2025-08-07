import java.util.*;
class Solution {
    int n;
    static int dp[][]=new int[1000][1000];
    void init(int n){
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],0,n-1-i,0);
            Arrays.fill(dp[i],n-1-i,n,-1);
        }
    }
    int f2(int i,int j,int[][]fruits){
        if(i<0 || i>=n || j<0 || j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=fruits[i][j]+Math.max(f2(i-1,j-1,fruits),Math.max(f2(i-1,j,fruits),f2(i-1,j+1,fruits)));
    }
    int f3(int i,int j,int[][]fruits){
        if(i<=0 || i>=n || j<0 || j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=fruits[i][j]+Math.max(f3(i-1,j-1,fruits),Math.max(f3(i,j-1,fruits),f3(i+1,j-1,fruits)));
    }
    public int maxCollectedFruits(int[][] fruits) {
        n=fruits.length;
        int diagonal=0;
        for(int i=0;i<n;i++) diagonal+=fruits[i][i];
        init(n);
        int child3=f3(n-1,n-2,fruits);
        return diagonal+child3+f2(n-2,n-1,fruits);
    }
}