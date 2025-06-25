class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left=(long)-Math.pow(10,10);
        long right=(long) Math.pow(10,10);
        while(left<right){
            long mid=left+(right-left)/2;
            if(countProd(nums1,nums2,mid)<k) left=mid+1;
            else right=mid;
        }
        return left;
    }
    public long countProd(int nums1[],int nums2[],long target){
        long count=0;
        for(int n: nums1){
            if(n==0){
            if(target>=0) count+=nums2.length;
            continue;
            }
           int low=0;
           int high=nums2.length;
           while(low<high){
            int mid=low+(high-low)/2;
            long prod=(long)n*nums2[mid];
            if(prod<=target){
                if(n>0) low=mid+1;
                else high=mid;
            }
            else{
                if(n>0) high=mid;
                else low=mid+1;
            }
           }
           if(n>0) count+=low;
           else count+=nums2.length-low;
        }
        return count;
    }
}