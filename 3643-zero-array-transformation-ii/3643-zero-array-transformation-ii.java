class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int l=0,r=queries.length;
        if(!current(nums,queries,r)) return -1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(current(nums,queries,mid))r=mid-1;
            else l=mid+1;
        }
        return l;
    }
    public boolean current(int[] nums,int[][]queries,int k){
        int sum=0;
        int[] difference=new int[nums.length+1];
        for(int i=0;i<k;i++){
            int l=queries[i][0],r=queries[i][1],val=queries[i][2];
            difference[l]+=val;
            difference[r+1]-=val;
        }
        for(int j=0;j<nums.length;j++){
            sum+=difference[j];
            if(sum<nums[j]) return false;
        }
        return true;
    }
}