class Solution {
    public int maxDifference(String s, int k) {
        int res=Integer.MIN_VALUE;
        for(int a=0;a<=4;a++){
            for(int b=0;b<=4;b++){
                if(a==b) continue;
                int s1[]=new int[s.length()+1];
                int s2[]=new int[s.length()+1];
                for(int i=1;i<=s.length();i++){
                    if(s.charAt(i-1)-'0'==a) s1[i]=s1[i-1]+1;
                    else s1[i]=s1[i-1];
                    if(s.charAt(i-1)-'0'==b) s2[i]=s2[i-1]+1;
                    else s2[i]=s2[i-1];
                }
                int lookup[][]=new int[2][2];
                for(int i=0;i<2;i++) Arrays.fill(lookup[i],Integer.MIN_VALUE);
                int j=0;
                for(int i=k;i<=s.length();i++){
                    while(i-j>=k && s1[i]>s1[j] && s2[i]>s2[j]){
                        int n1=s1[j]%2;
                        int n2=s2[j]%2;
                        lookup[n1][n2]=Math.max(lookup[n1][n2],s2[j]-s1[j]);
                        j++;
                    }
                    int n1=s1[i]%2;
                    int n2=s2[i]%2;
                    int nice=lookup[1-n1][n2];
                    if(nice!=Integer.MIN_VALUE) res=Math.max(res,(s1[i]-s2[i])+nice);
                }
            }
        }
        if(res==Integer.MIN_VALUE) return -1;
        else return res;
    }
}