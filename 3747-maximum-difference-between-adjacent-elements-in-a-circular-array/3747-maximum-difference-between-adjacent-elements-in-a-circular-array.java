class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int num[]=new int[nums.length+1];
            for(int i=0;i<nums.length;i++) num[i]=nums[i];
            num[num.length-1]=nums[0];
            int diff=0;
            int max=0;
            for(int i=1;i<num.length;i++){
                diff=Math.abs(num[i]-num[i-1]);
                max=Math.max(diff,max);
            }
            return max;
    }
}