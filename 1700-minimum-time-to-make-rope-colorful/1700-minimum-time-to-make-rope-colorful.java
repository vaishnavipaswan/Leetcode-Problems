class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int sum=0;
        for(int i=1;i<n;i++){
            int max=0;
            while(i<n && colors.charAt(i)==colors.charAt(i-1)){
                sum+=neededTime[i-1];
                max=Math.max(max,neededTime[i-1]);
                i++;
            }
            sum+=neededTime[i-1];
            max=Math.max(max,neededTime[i-1]);
            if(max!=0) sum-=max;
        }
        return sum;
    }
}