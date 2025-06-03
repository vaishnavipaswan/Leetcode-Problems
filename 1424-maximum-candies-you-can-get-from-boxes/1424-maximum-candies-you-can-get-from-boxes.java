class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        List<Integer> initial=new ArrayList<>();
        for(int i: initialBoxes) initial.add(i);
        boolean open=true;
        int total=0;
        while(!initial.isEmpty()  && open){
            open=false;
            List<Integer> next=new ArrayList<>();
            for(int i:initial){
                if(status[i]==1){
                open=true;
                for(int j:containedBoxes[i]) next.add(j);
                for(int k:keys[i]) status[k]=1;
                total+=candies[i];
                }
                else next.add(i);
            }
            initial=next; 
        }
        return total;
    }
}