import java.util.Arrays;
class Solution {
    public int minCapability(int[] nums, int k) {
        if (nums.length == 1)
            return nums[0];
        int low = Arrays.stream(nums).min().getAsInt(); 
        int high = Arrays.stream(nums).max().getAsInt();
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (maxHousesToSteal(mid, nums) >= k) {
                res = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return res;
    }
    private int maxHousesToSteal(int maxCapability, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxCapability) {
                count++;
                i++;
            }
        }
        return count;
    }
}
