class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=0;
        int right=0;
        List<Integer> res=new ArrayList<>();
        while(left<m && right<n){
            if(nums1[left]<=nums2[right]){
                res.add(nums1[left]);
                left++;
            }
            else{
                res.add(nums2[right]);
                right++;
            }
        }
        while(left<m){
                res.add(nums1[left]);
                left++;
            }
        while(right<n){
                res.add(nums2[right]);
                right++;
            }
        for(int i=0;i<res.size();i++) nums1[i]=res.get(i);
    }
}