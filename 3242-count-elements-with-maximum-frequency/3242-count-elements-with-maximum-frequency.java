class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int max=0;
        int res=0;
        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(int i:freq.values()){
            max=Math.max(i,max);
        }
        for(int i: freq.values()){
            if(i==max) res+=i;
        }
        return res;
    }
}