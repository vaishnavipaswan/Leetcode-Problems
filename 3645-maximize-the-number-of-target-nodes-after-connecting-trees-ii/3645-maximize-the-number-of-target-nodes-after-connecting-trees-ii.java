class Solution {
    int evenA,oddA,evenB,oddB;
    List<List<Integer>> graph(int[][] edges){
        int n=edges.length+1;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
    void dfs(List<List<Integer>> adj,int u,int parent,int[] color,boolean isA){
        if(color[u]==0){
            if(isA) evenA++;
            else evenB++;
        }else{
            if(isA) oddA++;
            else oddB++;
        }
        for(int v:adj.get(u)) if(v!=parent){
            color[v]=color[u]^1;
            dfs(adj,v,u,color,isA);
        }
    }
    public int[] maxTargetNodes(int[][] edges1,int[][] edges2){
        List<List<Integer>> adjA=graph(edges1);
        List<List<Integer>> adjB=graph(edges2);
        int n=adjA.size();
        int m=adjB.size();
        int colorA[]=new int[n];
        int colorB[]=new int[m];
        evenA=0;
        oddA=0;
        evenB=0;
        oddB=0;
        Arrays.fill(colorA,-1);
        Arrays.fill(colorB,-1);
        colorA[0]=0;
        dfs(adjA,0,-1,colorA,true);
        colorB[0]=0;
        dfs(adjB,0,-1,colorB,false);
        int max=Math.max(evenB,oddB);
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(colorA[i]==0) res[i]=evenA+max;
            else res[i]=oddA+max;
        }
        return res;
    }
}