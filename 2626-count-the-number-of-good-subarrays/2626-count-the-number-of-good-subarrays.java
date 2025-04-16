class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long count=0,pairs=0;
        int l=0;
        for (int r=0;r<nums.length;r++) {
            pairs+=map.getOrDefault(nums[r],0);
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while (pairs>=k) {
                count+=nums.length-r;
                pairs-=map.get(nums[l])-1;
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
        }
        return count;
    }
}