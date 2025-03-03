class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int res[]=new int[nums.length];
        int left=0,right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            int j=nums.length-1-i;
                if(pivot>nums[i]){
                    res[left]=nums[i];
                    left++;
                }
                if(pivot<nums[j]){
                    res[right]=nums[j];
                    right--;
                }
            }
            while(right>=left){
                res[left]=pivot;
                left++;
            }
            return res;
        }
}