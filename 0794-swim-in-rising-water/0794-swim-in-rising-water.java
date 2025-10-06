class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        Set<String> seen=new HashSet<>();
        pq.offer(new int[]{grid[0][0],0,0});
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int max_d=curr[0];
            int r=curr[1];
            int c=curr[2];
            String key=r+","+c;
            if(seen.contains(key))continue;
            seen.add(key);
            if(r==m-1 && c==n-1)return max_d;
            for(int d[]:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && !seen.contains(nr+","+nc)){
                    int new_d=Math.max(max_d,grid[nr][nc]);
                    pq.offer(new int[]{new_d,nr,nc});
                }
            }
        }
        return -1;
    }
}