class Solution {
    public static final int mod=1000000007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long freq[]=new long[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        long base[][]=new long[26][26];
        for(int i=0;i<26;i++){
            int n=nums.get(i);
            for(int k=1;k<=n;k++){
                base[i][(i+k)%26]++;
            }
        }
        long mat[][]=matrix(base,t);
        long res=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0)continue;
            for(int j=0;j<26;j++) res=(res+freq[i]*mat[i][j])%mod;
        }
        return (int)res;
    }
    public long[][] matrix(long m[][],int exp){
        long res[][]=new long[26][26];
        for(int i=0;i<26;i++) res[i][i]=1;
        long base[][]=m;
        while(exp>0){
            if((exp&1)==1) res=mul(res,base);
            base=mul(base,base);
            exp>>=1;
        }
        return res;
    }
    public long[][] mul(long a[][],long b[][]){
        long c[][]=new long[26][26];
        for(int i=0;i<26;i++){
            for(int k=0;k<26;k++){
                if(a[i][k]==0) continue;
                for(int j=0;j<26;j++) c[i][j]=(c[i][j]+a[i][k]*b[k][j])%mod;
            }
        }
        return c;
    }
}