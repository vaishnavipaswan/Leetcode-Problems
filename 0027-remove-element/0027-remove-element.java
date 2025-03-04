class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}