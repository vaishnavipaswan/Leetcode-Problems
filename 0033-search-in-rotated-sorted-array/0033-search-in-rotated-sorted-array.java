class Solution {
    public int search(int[] nums, int target) {
        int p=pivot(nums);
        if(p==-1) return binarySearch(nums,target,0,nums.length-1);
        if(target==nums[p]) return p;
        if(target>=nums[0]) return binarySearch(nums,target,0,p);
        else return binarySearch(nums,target,p+1,nums.length-1);
    }
    public static int binarySearch(int nums[],int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) start=mid+1;
            else end=mid-1;
        }
        return -1;
    }
    public static int pivot(int nums[]){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
             if(mid<end && nums[mid]>nums[mid+1]) return mid;
             if(mid>start && nums[mid]<nums[mid-1]) return mid-1;
             if(nums[mid]<=nums[start]) end= mid-1;
            else start=mid+1;
        }
        return -1;
    }
}