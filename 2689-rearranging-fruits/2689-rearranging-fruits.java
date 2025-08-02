class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int n:basket1){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int n: basket2){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Long>sort=new ArrayList<>();
        for(int n: map.values()){
            if(n%2!=0) return -1;
        }
        int min=Integer.MAX_VALUE;
        for(int i: map.keySet()){
            min=Math.min(min,i);
        }
        Map<Integer,Integer> count=new HashMap<>();
        for(int i:basket1) count.put(i,count.getOrDefault(i,0)+1);
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int f=e.getKey();
            int diff=count.getOrDefault(f,0)-(e.getValue()/2);
            for(int i=0;i<Math.abs(diff);i++){
                sort.add((long)f);
            }
        }
        Collections.sort(sort);
        long res=0;
        for(int i=0;i<sort.size()/2;i++){
            res+=Math.min(sort.get(i),2*min);
        }
        return res;
    }
}