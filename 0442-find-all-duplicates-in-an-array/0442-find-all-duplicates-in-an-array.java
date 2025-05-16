class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer>res=new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key)>1) res.add(key);
        }
        return res;
    }
}