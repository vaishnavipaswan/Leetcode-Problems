class Solution {
    public long depth(long cur,int n){
        long count=0;
        long c=cur;
        long next=cur+1;
        while(c<=n){
            count+=Math.min(n+1,next)-c;
            c*=10;
            next*=10;
        }
        return count;
    }
    public int findKthNumber(int n, int k) {
        long curr=1;
        k--;
        while(k>0){
            long count=depth(curr,n);
            if(k>=count){
                curr++;
                k-=count;
            }
            else{
                curr*=10;
                k--;
            }
        }
        return (int)curr;
    }
}