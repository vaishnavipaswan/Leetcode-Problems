class Solution {
    long func(long num){
        if(num<=0) return 0;
        if(num<=3) return num;
        int count=2;
        int pre=3;
        long res=3;
        for(int i=4;i<=num;i*=4){
            long upper=1L*i*4-1;
            long range;
            if(upper>=num){
                range=num-pre;
                res+=range*count;
                break;
            }
            else{
                range=upper-pre;
                pre=(int)upper;
                res+=(range*count);
                count++;
            }
        }
        return res;
    }
    public long minOperations(int[][] queries) {
        long res=0;
        for(int q[]:queries){
            int left=q[0],right=q[1];
            long val1=func(right);
            long val2=func(left-1);
            long diff=val1-val2;
            if(diff%2==1) diff++;
            res+=diff/2;
        }
        return res;
    }
}