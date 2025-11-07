class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n=stations.length;
        long power[]=new long[n];
        long window=0;
        int windowSize=2*r+1;
        for(int j=0;j<=Math.min(n-1,r);j++){
            window+=stations[j];
        }
        for(int i=0;i<n;i++){
            power[i]=window;
            int remove=i-r;
            if(remove>=0) window-=stations[remove];
            int add=i+r+1;
            if(add<n) window+=stations[add];
        }
        long low=0;
        long max=0L;
        for(long p: power){
            if(p>max) max=p;
        }
        long high=max+k;
        long res=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(reach(power,r,k,mid)){
                res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return res;
    }
    public boolean reach(long power[],int r,long k,long target){
        int n=power.length;
        long used=0L;
        long diff[]=new long[n+1];
        long curr=0L;
        for(int i=0;i<n;i++){
            curr+=diff[i];
            long total=power[i]+curr;
            if(total<target){
                long need=target-total;
                used+=need;
                if(used>k) return false;
                curr+=need;
                int end=Math.min(n,i+2*r+1);
                diff[end]-=need;
            }
        }
        return true;
    }
}