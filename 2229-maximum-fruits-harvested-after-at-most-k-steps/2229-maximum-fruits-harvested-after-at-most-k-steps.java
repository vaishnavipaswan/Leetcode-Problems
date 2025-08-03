class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left=0;
        int sum=0;
        int max=0;
        for(int i=0;i<fruits.length;i++){
            sum+=fruits[i][1];
            while(left<=i && minStep(fruits[left][0],fruits[i][0],startPos)>k){
                sum-=fruits[left][1];
                left++;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
    public int minStep(int l,int r,int s){
        int left=Math.abs((s-l))+(r-l);
        int right=Math.abs((r-s))+(r-l);
        return Math.min(left,right);
    }
}