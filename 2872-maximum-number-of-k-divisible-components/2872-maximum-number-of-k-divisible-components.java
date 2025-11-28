class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int res[]=new int[1];
        dfs(adj,values,0,-1,res,k);
        return res[0];
    }
    public int dfs(List<List<Integer>> adj,int values[],int node,int parent,int res[],int k){
        int sum=values[node];
        for(int i:adj.get(node)){
            if(i!=parent){
                sum+=dfs(adj,values,i,node,res,k);
            }
        }
        if(sum%k==0) res[0]++;
        return sum%k;
    }
}