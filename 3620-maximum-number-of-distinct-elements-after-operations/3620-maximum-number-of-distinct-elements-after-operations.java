class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        int prev=(int)-1000000000;
        for(int i:nums){
            int l=Math.max(i-k,prev+1);
            if(l<=i+k){
                prev=l;
                res++;
            }
        }
        return res;
    }
}