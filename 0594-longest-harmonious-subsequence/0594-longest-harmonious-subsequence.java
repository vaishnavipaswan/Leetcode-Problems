class Solution {
    public int findLHS(int[] nums) {
        int max=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int k: map.keySet()){
            if(map.containsKey(k+1)) max=Math.max(max,map.get(k)+map.get(k+1));
        }
        return max;
    }
}