class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Map<Integer,PriorityQueue<Integer>> maxq=new HashMap<>();
        Map<Integer,PriorityQueue<Integer>> minq=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(i-j>=0){
                maxq.putIfAbsent(i-j,new PriorityQueue<>(Collections.reverseOrder()));
                maxq.get(i-j).add(grid[i][j]);
                }
                else {
                    minq.putIfAbsent(i-j,new PriorityQueue<>());
                    minq.get(i-j).add(grid[i][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i-j>=0) {
                    grid[i][j]=maxq.get(i-j).poll();
                }
                else {
                    grid[i][j]=minq.get(i-j).poll();
                }
            }
        }
        return grid;
    }
}