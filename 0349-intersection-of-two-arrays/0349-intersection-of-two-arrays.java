class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> res=new HashSet<>();
        for(int num:nums1) set1.add(num);
        for(int n:nums2){
            if(set1.contains(n)) res.add(n);
        }
        int ans[]=new int[res.size()];
        int i=0;
        for(int num:res) ans[i++]=num;
        return ans;
    }
}