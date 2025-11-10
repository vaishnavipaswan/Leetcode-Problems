class Solution {
    public int minOperations(int[] nums) {
        int st[]=new int[nums.length+1];
        Arrays.fill(st,0);
        int top=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            while(st[top]>nums[i]){
                top--;
                res++;
            }
            if(st[top]!=nums[i]){
                top++;
                st[top]=nums[i];
            }
        }
        return res+top;
    }
}