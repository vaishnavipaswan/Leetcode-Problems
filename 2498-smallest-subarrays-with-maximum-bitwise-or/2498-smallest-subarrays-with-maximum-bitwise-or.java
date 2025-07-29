class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int res[]=new int[nums.length];
        int last[]=new int[32];
        for(int i=0;i<nums.length;i++){
            res[i]=1;
        }
            for(int j=nums.length-1;j>=0;j--){
                for(int b=0;b<30;b++){
                    if((nums[j]&(1<<b))>0) last[b]=j;
                    res[j]=Math.max(res[j],last[b]-j+1);
                }
            }
        return res;
    }
}