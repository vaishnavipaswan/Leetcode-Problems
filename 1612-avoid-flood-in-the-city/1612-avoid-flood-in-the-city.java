class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> lakeDay=new HashMap<>();
        TreeSet<Integer> dryDays=new TreeSet<>();
        int n=rains.length;
        int res[]=new int[n];
        Arrays.fill(res,1);
        for(int i=0;i<n;i++){
            int lake=rains[i];
            if(lake==0) dryDays.add(i);
            else{
                res[i]=-1;
                if(lakeDay.containsKey(lake)){
                    Integer dryDay=dryDays.higher(lakeDay.get(lake));
                    if(dryDay==null) return new int[0];
                    res[dryDay]=lake;
                    dryDays.remove(dryDay);
                }
                lakeDay.put(lake,i);
            }
        }
        return res;
    }
}