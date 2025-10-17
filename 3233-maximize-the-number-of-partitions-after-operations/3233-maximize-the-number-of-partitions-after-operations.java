class Solution {
    public int maxPartitionsAfterOperations(String s,int k) {
        if(k==26)return 1;
        int n=s.length();
        int[] mask=new int[n];
        int[] dup=new int[n];
        int[] parts=new int[n];
        int m=0,d=0,p=1;
        for(int i=0;i<n;i++) {
            int bit=1<<(s.charAt(i)-'a');
            d|=m&bit;
            m|=bit;
            if(Integer.bitCount(m)>k) {
                m=bit;
                d=0;
                p++;
            }
            mask[i]=m;
            dup[i]=d;
            parts[i]=p;
        }
        int res=p;
        m=0;
        d=0;
        p=0;
        for(int i=n-1;i>=0;i--) {
            int bit=1<<(s.charAt(i)-'a');
            d|=m&bit;
            m|=bit;
            int bitCount=Integer.bitCount(m);
            if(bitCount>k) {
                m=bit;
                d=0;
                p++;
            }
            if(bitCount==k) {
                if(((bit&d)!=0)&&
                   ((bit&dup[i])!=0)&&
                   (Integer.bitCount(mask[i])==k)&&
                   ((mask[i]|m)!=(1<<26)-1)) {
                    res=Math.max(res,p+parts[i]+2);
                } else if(d!=0) {
                    res=Math.max(res,p+parts[i]+1);
                }
            }
        }
        return res;
    }
}