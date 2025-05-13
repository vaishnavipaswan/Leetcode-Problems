class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int n=s.length();
        long res=0;
        long mod=1000000007;
        long[] count=new long[130];
        for(char ch:s.toCharArray()) count[ch]++;
        while(t-->0){
            long temp[]=new long[130];
            for(char ch='z';ch>='a';ch--){
                if(ch=='z'){
                    temp['a']=count[ch];
                    temp['b']=count[ch];
                }
                else temp[ch+1]+=count[ch];
                temp[ch]%=mod;
            }
            count=temp;
        }
        for(char ch='z';ch>='a';ch--)res+=(count[ch]%mod);
        return (int) (res%mod);
    }
}