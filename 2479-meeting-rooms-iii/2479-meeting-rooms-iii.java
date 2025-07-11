class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int count[]=new int[n];
        long busy[]=new long[n];
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        for(int m[]: meetings){
            int start=m[0];
            int end=m[1];
            int roomIdx=-1;
            long earliest=Long.MAX_VALUE;
            boolean assigned=false;
            for(int i=0;i<n;i++){
                if(busy[i]<earliest){
                    earliest=busy[i];
                    roomIdx=i;
                }
                if(busy[i]<=start){
                    busy[i]=end;
                    count[i]++;
                    assigned=true;
                    break;
                }
            }
            if(!assigned){
                busy[roomIdx]+=(end-start);
                count[roomIdx]++;
            }
        }
        int max=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(count[i]>max){
                max=count[i];
                res=i;
            }
        }
        return res;
    }
}