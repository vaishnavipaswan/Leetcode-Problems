class Solution {
    public int maximumLength(int[] nums) {
        int odd=0;
        int even=0;
        int parity=nums[0]%2;
        int res=1;
        if(nums.length==2) return 2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) even++;
            else odd++;
            if((nums[i]%2) != (parity%2)) {
                parity^=1;
                res++;
            }
        }
        return Math.max(res,Math.max(odd,even));
    }
}