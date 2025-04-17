class Solution {
    public int countPairs(int[] nums, int k) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            while(j<nums.length){
                if(nums[i]==nums[j] && (i*j)%k==0){
                    res++;
                }
                j++;
            }
        }
        return res;
    }
}