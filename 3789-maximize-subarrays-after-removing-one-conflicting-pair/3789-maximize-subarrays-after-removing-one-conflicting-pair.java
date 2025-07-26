class Solution{
    public long maxSubarrays(int n,int[][] conflictingPairs){
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=1;i<=n;i++) map.put(i,new ArrayList<>());
        for(int[] pair:conflictingPairs){
            int a=Math.max(pair[0],pair[1]);
            int b=Math.min(pair[0],pair[1]);
            map.get(a).add(b);
        }
        long res=0;
        long[] top={0,0};
        long[] extra=new long[n+1];
        for(int r=1;r<=n;r++){
            for(int lVal:map.get(r)){
                if(lVal>top[0]){
                    top[1]=top[0];
                    top[0]=lVal;
                }else if(lVal>top[1]){
                    top[1]=lVal;
                }
            }
            res+=r-top[0];
            if(top[0]>0) extra[(int)top[0]]+=top[0]-top[1];
        }
        long maxExtra=0;
        for(long val:extra) maxExtra=Math.max(maxExtra,val);
        return res+maxExtra;
    }
}