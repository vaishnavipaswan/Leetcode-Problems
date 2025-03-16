class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l=1,r=(long)cars*cars*ranks[0];
        long res=-1;
        while(l<=r){
            long mid=(l+r)/2;
            if(repair_cars(mid,ranks)>=cars){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    public long repair_cars(long time,int[] rank){
            long count=0;
            for(int i=0;i<rank.length;i++){
                count+=(long)Math.sqrt((double)time/rank[i]);
            }
            return count;
    }
}