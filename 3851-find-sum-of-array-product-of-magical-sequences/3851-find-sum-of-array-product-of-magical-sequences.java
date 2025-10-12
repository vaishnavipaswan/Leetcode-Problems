class Solution {
    public int magicalSum(int m, int k, int[] nums) {
        int MOD=1000000007;
        int n=nums.length;
        int c[][]=new int[m+1][m+1];
        for(int i=0;i<=m;i++){
            c[i][0]=c[i][i]=1;
            for(int j=1;j<i;j++){
                c[i][j]=(c[i-1][j-1]+c[i-1][j])% MOD;
            }
        }
        int pow[][]=new int[n][m+1];
        for(int i=0;i<n;i++){
            pow[i][0]=1;
            for(int j=1;j<=m;j++){
                pow[i][j]=(int)((long)pow[i][j-1]*nums[i]% MOD);
            }
        }
        int dp[][][][]=new int[n+1][k+1][m+1][m+1];
        dp[0][0][0][0]=1;
        for(int pos=0;pos<n;pos++){
            for(int bits=0;bits<=k;bits++){
                for(int carry=0;carry<=m;carry++){
                    for(int choosen=0;choosen<=m;choosen++){
                        if(dp[pos][bits][carry][choosen]==0) continue;
                        int rem=m-choosen;
                        for(int i=0;i<=rem;i++){
                            int total=carry+i;
                            int new_bits=bits+(total & 1);
                            int new_carry=total>>1;
                            if(new_bits<=k && new_carry<=m){
                                long add=(long)dp[pos][bits][carry][choosen]*c[rem][i] % MOD * pow[pos][i] % MOD;
                                dp[pos+1][new_bits][new_carry][choosen+i]=(dp[pos+1][new_bits][new_carry][choosen+i]+(int)add)% MOD;
                            }
                        }
                    }
                }
            }
        }
        int res=0;
        for(int i=0;i<=m;i++){
            int final_bits=k;
            int carry_bits=Integer.bitCount(i);
            if(carry_bits<=k){
                res=(res+dp[n][k-carry_bits][i][m])% MOD;
            }
        }
        return res;
    }
}