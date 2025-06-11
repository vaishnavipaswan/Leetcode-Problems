class Solution {
    public int maxFrequencyElements(int[] nums) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i: nums) map.put(i,map.getOrDefault(i,0)+1);
        int max=0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            max=Math.max(max,e.getValue());
        }
        for(int i: nums){
            if(map.get(i)==max) count++;
        }
        return count;
    }
}