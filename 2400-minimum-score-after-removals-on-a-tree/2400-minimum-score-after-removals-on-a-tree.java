class Solution {
    int count=0;
    int[] xor,in,out;
    public int minimumScore(int[] nums,int[][] edges){
        int n=nums.length;
        List<List<Integer>> graph=new ArrayList<>();
        xor=new int[n];
        in=new int[n];
        out=new int[n];
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs(0,-1,graph,nums);
        int res=Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0],b=edges[i][1];
            int u=isAncestor(a,b)?b:a;
            for(int j=i+1;j<edges.length;j++){
                int c=edges[j][0],d=edges[j][1];
                int v=isAncestor(c,d)?d:c;
                int[] vals=new int[3];
                if(isAncestor(u,v)){
                    vals[0]=xor[v];
                    vals[1]=xor[u]^xor[v];
                    vals[2]=xor[0]^xor[u];
                }else if(isAncestor(v,u)){
                    vals[0]=xor[u];
                    vals[1]=xor[v]^xor[u];
                    vals[2]=xor[0]^xor[v];
                }else{
                    vals[0]=xor[u];
                    vals[1]=xor[v];
                    vals[2]=xor[0]^xor[u]^xor[v];
                }
                Arrays.sort(vals);
                res=Math.min(res,vals[2]-vals[0]);
            }
        }
        return res;
    }
    public void dfs(int node,int parent,List<List<Integer>> graph,int[] nums){
        in[node]=count++;
        xor[node]=nums[node];
        for(int nei:graph.get(node)){
            if(nei!=parent){
                dfs(nei,node,graph,nums);
                xor[node]^=xor[nei];
            }
        }
        out[node]=count++;
    }
    public boolean isAncestor(int u,int v){
        return in[u]<=in[v]&&out[v]<=out[u];
    }
}