class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1=graph(edges1);
        List<List<Integer>> adj2=graph(edges2);
        int max=0;
        int n=adj1.size();
        int m=adj2.size();
        int res[]=new int[n];
        for(int i=0;i<m;i++) max=Math.max(max,dfs(adj2,i,-1,k-1));
        for(int i=0;i<n;i++) res[i]=dfs(adj1,i,-1,k)+max;
        return res;
    }
    public List<List<Integer>> graph(int[][] edges){
        int n=edges.length+1;
        List<List<Integer>> adj=new ArrayList<>(n);
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
    public int dfs(List<List<Integer>> adj,int u,int p,int k){
        if(k<0) return 0;
        int count=1;
        for(int v:adj.get(u)) if(v!=p) count+=dfs(adj,v,u,k-1);
        return count;
    }
}