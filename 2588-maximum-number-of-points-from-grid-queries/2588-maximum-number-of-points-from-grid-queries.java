class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m=grid.length,n=grid[0].length;
        int[] res=new int[queries.length];
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int[][] sortQueries=new int[queries.length][2];
        for (int i=0;i<queries.length;i++) {
            sortQueries[i][0]=queries[i];
            sortQueries[i][1]=i;
        }
        Arrays.sort(sortQueries,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visited=new boolean[m][n];
        int total=0;
        minHeap.add(new int[]{grid[0][0], 0, 0});
        visited[0][0]=true;
        for (int[] query:sortQueries) {
            int qval=query[0],qid=query[1];
            while (!minHeap.isEmpty() && minHeap.peek()[0]<qval) {
                int[] top=minHeap.poll();
                int currentRow=top[1],currentCol=top[2];
                total++;
                for (int[] d:dir) {
                    int newRow=currentRow+d[0], newCol=currentCol+d[1];
                    if (newRow>=0 && newCol>=0 && newRow<m && newCol<n && !visited[newRow][newCol]){
                        minHeap.add(new int[]{grid[newRow][newCol], newRow, newCol});
                        visited[newRow][newCol]=true;
                    }
                }
            }
            res[qid]=total;
        }
        return res;
    }
}