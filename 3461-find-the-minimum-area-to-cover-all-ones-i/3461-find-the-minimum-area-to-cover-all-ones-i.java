class Solution {
    public int minimumArea(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int minrow=m;
        int mincol=n;
        int maxrow=-1;
        int maxcol=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    minrow=Math.min(minrow,i);
                    maxrow=Math.max(maxrow,i);
                    mincol=Math.min(mincol,j);
                    maxcol=Math.max(maxcol,j);
                }
            }
        }
        int h=maxrow-minrow+1;
        int w=maxcol-mincol+1;
        int area=h*w;
        return area;
    }
}