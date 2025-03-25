class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] x=new int[rectangles.length][2];
        int[][] y=new int[rectangles.length][2];
        for(int i=0;i<rectangles.length;i++){
            x[i][0]=rectangles[i][0];
            y[i][0]=rectangles[i][1];
            x[i][1]=rectangles[i][2];
            y[i][1]=rectangles[i][3];
        }
        if(overlapping(x)||overlapping(y)) return true;
        return false;
    }
    boolean overlapping(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] curr=intervals[0];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            if(curr[1]>start) curr[1]=Math.max(intervals[i][1],curr[1]);
            else{
                count++;
                curr=intervals[i];
            }
            if(count==2) return true;
        }
        return false;
    }
}