class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
        int gap[]=new int[n+1];
        for(int i=1;i<n;i++) gap[i]=startTime[i]-endTime[i-1];
        gap[0]=startTime[0];
        gap[n]=eventTime-endTime[n-1];
        int i=0;
        int j=k;
        int max=0;
        int sum=0;
        for(int m=i;m<=n && m<=j;m++) sum+=gap[m];
        max=Math.max(max,sum);
        while(j<n){
            sum-=gap[i++];
            sum+=gap[++j];
            max=Math.max(max,sum);
        }
        return max;
    }
}