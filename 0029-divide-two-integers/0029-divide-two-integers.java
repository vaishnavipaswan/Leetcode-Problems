class Solution {
    public int divide(int dividend,int divisor){
        if(dividend==divisor) return 1;
        boolean positive=(dividend<0==divisor<0);
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        long result=0;
        while(a>=b){
            long temp=b,multiple=1;
            while(a>=(temp<<1)){
                temp<<=1;
                multiple<<=1;
            }
            a-=temp;
            result+=multiple;
        }
        if(result>Integer.MAX_VALUE) return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return positive?(int)result:(int)-result;
    }
}