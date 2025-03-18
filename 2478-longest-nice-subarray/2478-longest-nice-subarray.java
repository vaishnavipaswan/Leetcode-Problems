class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start=0;
        int usedbits=0;
        int max=0;
        for(int end=0;end<nums.length;end++){
            while((usedbits & nums[end])!=0){
                usedbits^=nums[start];
                start++;
            }
            usedbits|=nums[end];
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}