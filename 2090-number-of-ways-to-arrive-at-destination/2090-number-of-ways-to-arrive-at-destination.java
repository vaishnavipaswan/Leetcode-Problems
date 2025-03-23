class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads){
            int u=road[0],v=road[1],w=road[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int mod=(int)(1e9+7);
       long[] mincost=new long[n];
       Arrays.fill(mincost,Long.MAX_VALUE);
       mincost[0]=0;
       int[] pathcount=new int[n];
       pathcount[0]=1;
       boolean[] visited=new boolean[n];
       for(int i=0;i<n;i++){
        int node=-1;
        for(int j=0;j<n;j++){
            if(!visited[j] && (node==-1 ||mincost[j]<mincost[node])){
                node=j;
            }
        }
        if(mincost[node]==Long.MAX_VALUE) break;
        visited[node]=true;
        for(int[] edge: adj.get(node)){
            int nei=edge[0];
            long neicost=edge[1];
            if(mincost[node]+neicost<mincost[nei]){
                mincost[nei]=mincost[node]+neicost;
                pathcount[nei]=pathcount[node];
            }
            else if(mincost[node]+neicost==mincost[nei]){
                pathcount[nei]=(pathcount[nei]+pathcount[node])%mod;
            }
        }
       }
        return pathcount[n-1];
    }
}