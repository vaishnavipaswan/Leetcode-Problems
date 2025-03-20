class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent=new int[n];
        int[] minPathCost=new int[n];
        Arrays.fill(minPathCost,-1);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            int src=edge[0],target=edge[1],weight=edge[2];
            int srcroot=findroot(parent,src);
            int targetroot=findroot(parent,target);
            minPathCost[targetroot] &=weight;
            if(srcroot!=targetroot){
                minPathCost[targetroot]&=minPathCost[srcroot];
                parent[srcroot]=targetroot;
            }
        }
        int res[]=new int[query.length];
        for(int i=0;i<query.length;i++){
            int start=query[i][0],end=query[i][1];
            if(start==end){
                res[i]=0;
            }
            else if(findroot(parent,start)!=findroot(parent,end)){
                res[i]=-1;
            }
            else{
                res[i]=minPathCost[findroot(parent,start)];
            }
        }
        return res;
    }
    int findroot(int[] parent,int node){
        if(parent[node]!=node){
            parent[node]=findroot(parent,parent[node]);
        }
        return parent[node];
    }

}