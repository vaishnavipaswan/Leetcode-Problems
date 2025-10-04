class Solution {
    public int maxArea(int[] height) {
        int res=0;
        int i=0;
        int n=height.length;
        int j=n-1;
        while(i<j){
            res=Math.max(res,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return res;
    }
}