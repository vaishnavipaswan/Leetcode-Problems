class Solution {
    public int countGoodNumbers(long n) {
       if (n==1) return 5;
       long even=(n+1)/2;
       long odd=n/2;
       long mod=1000000007;
       return (int)((calculate(5,even,mod)*calculate(4,odd,mod))%mod);
    }
    public long calculate(long base,long exp,long mod){
         long res=1;
        while(exp>0){
            if(exp%2==0){
                base=(base*base)%mod;
                exp=exp/2;
            }
            else{
                res=(res*base)%mod;
                exp--;
            }
        }
        return res;
    }
}