class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k==1){
            return 0;
        }
        List<Integer> pairs=new ArrayList<Integer>();
        for(int i=0;i<weights.length-1;i++){
            pairs.add(weights[i]+weights[i+1]);
        }
        Collections.sort(pairs);
        long min=0,max=0;
        long res=0;
        for(int i=0;i<k-1;i++){
            min+=pairs.get(i);
            max+=pairs.get(pairs.size()-1-i);
            res=max-min;
        }
        return res;
    }
}