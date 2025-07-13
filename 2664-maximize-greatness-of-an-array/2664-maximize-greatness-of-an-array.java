class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int i=0;
        int j=0;
        while(i<nums.length){
            if(nums[j]<nums[i]) {
                count++;
                j++;
            }
            i++;
        }
        return count;
    }
}