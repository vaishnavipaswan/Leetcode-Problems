class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> s=new HashSet<>();
        int b=(int)Math.pow(10,(n-1)/2);
        int skip=n&1;
        for(int i=b;i<b*10;i++){
            String str=Integer.toString(i);
            str+=new StringBuilder(str).reverse().substring(skip);
            long palindrome=Long.parseLong(str);
            if(palindrome%k==0){
                char[] c=str.toCharArray();
                Arrays.sort(c);
                s.add(new String(c));
            }
        }
        long[] fact=new long[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++){
            fact[i]=fact[i-1]*i;
        }
        long res=0;
        for(String str: s){
            int[] count=new int[10];
            for(char c:str.toCharArray()){
                count[c-'0']++;
            }
            long total=(n-count[0])*fact[n-1];
            for(int x: count){
                total/=fact[x];
            }
            res+=total;
        }
        return res;
    }
}