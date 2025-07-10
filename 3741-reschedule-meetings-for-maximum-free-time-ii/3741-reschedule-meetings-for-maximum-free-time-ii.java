class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int gap[]=new int[startTime.length+1];
        gap[0]=startTime[0];
        for(int i=1;i<startTime.length;i++) gap[i]=startTime[i]-endTime[i-1];
        gap[startTime.length]=eventTime-endTime[endTime.length-1];
        int right[]=new int[gap.length];
        for(int i=gap.length-2;i>=0;i--) right[i]=Math.max(right[i+1],gap[i+1]);
        int res=0;
        int left=0;
        for(int i=1;i<gap.length;i++){
            int curr=endTime[i-1]-startTime[i-1];
            if(curr<=Math.max(left,right[i])) res=Math.max(res,gap[i-1]+gap[i]+curr);
            res=Math.max(res,gap[i-1]+gap[i]);
            left=Math.max(left,gap[i-1]);
        }
        return res;
    }
}