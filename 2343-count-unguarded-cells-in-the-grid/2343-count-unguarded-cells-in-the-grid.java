class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int vis[][]=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int g[]:guards){
            q.add(g);
            map.put(g[0]+","+g[1],1);
            vis[g[0]][g[1]]=1;
        }
        for(int w[]:walls){
            map.put(w[0]+","+w[1],1);
            vis[w[0]][w[1]]=1;
        }
        for(int g[]:guards){
            int r=g[0];
            int c=g[1];
            dfs(r,c+1,"r",vis,map);
            dfs(r,c-1,"l",vis,map);
            dfs(r+1,c,"d",vis,map);
            dfs(r-1,c,"u",vis,map);
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0) count++;
            }
        }
        return count;
    }
    void dfs(int r,int c,String dir,int vis[][],Map<String,Integer>map){
        int n=vis.length;
        int m=vis[0].length;
        if(r<0||c<0||r>=n||c>=m) return;
        if(map.containsKey(r+","+c)) return;
        vis[r][c]=1;
        if(dir.equals("r")) dfs(r,c+1,"r",vis,map);
        if(dir.equals("l")) dfs(r,c-1,"l",vis,map);
        if(dir.equals("u")) dfs(r-1,c,"u",vis,map);
        if(dir.equals("d")) dfs(r+1,c,"d",vis,map);
    }
}