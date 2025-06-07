class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones) max.add(i);
        while(max.size()>1){
            int y=max.poll();
            int x=max.poll();
            if(x<=y){
                max.add(y-x);
            }
        }
        if(!max.isEmpty()) return max.peek();
        return 0;
    }
}