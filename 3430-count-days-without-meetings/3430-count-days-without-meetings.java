class Solution {
    public int countDays(int days, int[][] meetings) {
        if (days<=0|| meetings==null || meetings.length==0) {
            return days;
        }
        int endl=0,count=0;
        Arrays.sort(meetings,Comparator.comparingInt(a->a[0]));
        for (int[] meeting:meetings) {
            int start=meeting[0];
            int end=meeting[1];   
            if(start>endl+1){
                count+=start-endl-1;
            } 
            endl=Math.max(endl,end);
        }
            count+=days-endl;
        return count;
    }
}