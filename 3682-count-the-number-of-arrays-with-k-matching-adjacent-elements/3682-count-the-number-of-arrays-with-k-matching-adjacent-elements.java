class Solution {
    int mod=1_000_000_007;
    static int[] fact=new int[100001];
    public int countGoodArrays(int n,int m,int k){
        if(fact[0]==0) fact[0]=1;
        long res=m,base=m-1,exp=n-1-k;
        while(exp>0){
            if((exp&1)==1) res=res*base%mod;
            base=base*base%mod;
            exp/=2;
        }
        res=res*getPos(n-1,n-1-k)%mod;
        return (int)res;
    }
    public long getPos(int a,int b){
        return (long)getFact(a)*reverse(getFact(a-b))%mod*reverse(getFact(b))%mod;
    }
    public long getFact(int a){
        if(fact[a]!=0) return fact[a];
        return fact[a]=(int)(getFact(a-1)*a%mod);
    }
    public long reverse(long a){
        if(a==1) return a;
        return mod-mod/a*reverse(mod%a)%mod;
    }
}