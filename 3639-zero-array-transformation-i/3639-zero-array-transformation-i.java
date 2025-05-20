class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int diff[]=new int[nums.length+1];
        for(int q[]:queries){
            int l=q[0];
            int r=q[1];
            diff[l]++;
            if(r+1<nums.length){
                diff[r+1]--;
            }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=diff[i];
            if(count<nums[i]) return false;
        }
        return true;
    }
}