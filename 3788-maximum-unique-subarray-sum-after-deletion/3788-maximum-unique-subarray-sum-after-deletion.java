class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int n:nums) set.add(n);
        int res=0;
        for(int n:set){
            if(n>0) {
                res+=n;
            }
        }
        if(res==0) res=Collections.max(set);
        return res;
    }
}