class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int left=Math.min(firstPlayer,secondPlayer);
        int right=Math.max(firstPlayer,secondPlayer);
        if(left+right==n+1) return new int[]{1,1};
        if(n==3 || n==4) return new int[]{2,2};
        if(left-1>n-right){
            int temp=n+1-left;
            left=n+1-right;
            right=temp;
        }
        int next=(n+1)/2;
        int min=n;
        int max=1;
        if(right*2<=n+1){
            int pre=left-1;
            int mid=right-left-1;
            for(int i=0;i<=pre;i++){
                for(int j=0;j<=mid;j++){
                    int res[]=earliestAndLatest(next,i+1,i+j+2);
                    min=Math.min(min,1+res[0]);
                    max=Math.max(max,1+res[1]);
                }
            }
        }
        else {
            int mirror=n+1-right;
            int pre=left-1;
            int mid=mirror-left-1;
            int inner=right-mirror-1;
            for(int i=0;i<=pre;i++){
                for(int j=0;j<=mid;j++){
                    int p1=i+1;
                    int p2=i+j+1+(inner+1)/2+1;
                    int res[]=earliestAndLatest(next,p1,p2);
                    min=Math.min(min,1+res[0]);
                    max=Math.max(max,1+res[1]);
                }
            }
        }
        return new int[]{min,max};
    }
}