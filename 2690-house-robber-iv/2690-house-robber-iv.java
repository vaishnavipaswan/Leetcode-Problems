class Solution {
    public int minCapability(int[] nums, int k) {
        if(nums.length==0) return 0;
        int min=nums[0],max=nums[0];
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        int left=min,right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            int take=countTake(nums,mid);
            if(take>=k){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;

    }
    public int countTake(int[] arr,int mid){
        int 
        count=0;
        int index=0;
        while(index<arr.length){
            if(arr[index]<=mid){
                count++;
                index+=2;
            }
            else{
                index++;
            }
        }
        return count;
    }
}
           