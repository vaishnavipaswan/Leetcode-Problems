class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res[][]=new int[nums.length/3][3];
        int m=0;
        for(int i=0;i<nums.length/3;i++){
            for(int j=0;j<3;j++){
                res[i][j]=nums[m++];
            }
        }
        for(int i=0;i<nums.length/3;i++){
                int a=res[i][0],b=res[i][1],c=res[i][2];
                if((c-a)>k)
                return new int[0][0];
        }
        return res;
    }
}