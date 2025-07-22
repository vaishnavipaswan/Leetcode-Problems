class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int j=0;
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
                while(set.contains(nums[i])){
                    set.remove(nums[j]);
                    sum-=nums[j];
                    j++;
                }
                set.add(nums[i]);
                sum+=nums[i];
                max=Math.max(max,sum);
        }
        return max;
    }
}