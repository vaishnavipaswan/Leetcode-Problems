class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        long res=0;
        int prefixsum=0;
        for(int i:nums){
            if(i%modulo==k)prefixsum++;
            res+=map.getOrDefault((prefixsum-k+modulo)%modulo,0);
            map.put(prefixsum%modulo,map.getOrDefault(prefixsum%modulo,0)+1);
        }
        return res;
    }
}