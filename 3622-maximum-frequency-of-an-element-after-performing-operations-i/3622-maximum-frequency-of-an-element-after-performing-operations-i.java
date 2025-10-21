class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer,Integer>freq=new HashMap<>();
        for(int i:nums) freq.put(i,freq.getOrDefault(i,0)+1);
        List<Integer> keys=new ArrayList<>(freq.keySet());
        Collections.sort(keys);
        int count=0;
        int res=0;
        int i=0,j=0;
        for(int n=keys.get(0);n<=keys.get(keys.size()-1);n++){
            while(j<keys.size() && keys.get(j)<=n+k){
                count+=freq.get(keys.get(j++));
            }
            while(i<keys.size() && keys.get(i)< n-k){
                count-=freq.get(keys.get(i++));
            }
            res=Math.max(res,Math.min(freq.getOrDefault(n,0)+numOperations,count));
        }
        return res;
    }
}