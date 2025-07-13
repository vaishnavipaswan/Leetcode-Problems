class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n=nums1.length;
        int m=0;
        int j=0;
        int res[][]=new int[n][2];
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            res[i][0]=nums2[i];
            res[i][1]=i;
        }
        Arrays.sort(res,(a,b)->Integer.compare(a[0],b[0]));
        int k=n-1;
        while(m<n){
            if(nums1[m]>res[j][0]){
                ans[res[j][1]]=nums1[m];
                j++;
            }
            else {
                ans[res[k][1]]=nums1[m];
                k--;
            }
            m++;
        }
        return ans;
    }
}