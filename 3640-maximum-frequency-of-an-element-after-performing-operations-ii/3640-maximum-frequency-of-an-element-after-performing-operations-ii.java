class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n=nums.length;
        Arrays.sort(nums);
        int res=0;
        int count=0;
        int l=0,r=0;
        for(int i=0;i<n;i++){
            int x=nums[i];
            int L=Math.max(1,x-k);
            int R=Math.min(nums[n-1],x+k);
            int f=1;
            int j=i+1;
            while(j<n && nums[j]==x){
                f++;
                j++;
            }
            i=j-1;
            while(l<n && nums[l]<L) l++;
            r=(r>i)?r:i;
            while(r+1<n && nums[r+1]<=R)r++;
            count=r-l+1;
            res=Math.max(res,f+Math.min(count-f,numOperations));
        }
        l=0;
        for(r=0;r<n;r++){
            int x=nums[r];
            int L=Math.max(1,x-2*k);
            while(l<r && nums[l]<L) l++;
            res=Math.max(res,Math.min(r-l+1,numOperations));
        }
        return res;
    }
}