class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int res=0;
        int n=colors.length();
        List<Integer> adj[]=new ArrayList[n];
        int count[][]=new int[n][26];
        boolean visited[]=new boolean[n];
        boolean path[]=new boolean[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
        for(int e[]: edges) adj[e[0]].add(e[1]);
        for(int i=0;i<n;i++){
            if(dfs(i,colors,adj,count,visited,path)==Integer.MAX_VALUE) return -1;
            res=Math.max(res,Arrays.stream(count[i]).max().getAsInt());
        }
        return res;
    }
    public int dfs(int node,String colors,List<Integer> adj[],int count[][],boolean visited[],boolean path[]){
        if(path[node]) return Integer.MAX_VALUE;
        if(visited[node]) return 0;

        visited[node]=true;
        path[node]=true;
        int cidx=colors.charAt(node)-'a';
        count[node][cidx]=1;
        for(int nei:adj[node]){
            if(dfs(nei,colors,adj,count,visited,path)==Integer.MAX_VALUE) return Integer.MAX_VALUE;
            for(int i=0;i<26;i++) count[node][i]=Math.max(count[node][i],(i==cidx?1:0)+count[nei][i]);
        }
        path[node]=false;
        return Arrays.stream(count[node]).max().getAsInt();
    }
}