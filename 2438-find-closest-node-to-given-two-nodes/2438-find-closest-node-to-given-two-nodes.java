class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int res=-1;
        int check=Integer.MAX_VALUE;
        int n=edges.length;
        int d1[]=new int[n];
        Arrays.fill(d1,-1);
        int d2[]=new int[n];
        Arrays.fill(d2,-1);
        dfs(node1,0,edges,d1);
        dfs(node2,0,edges,d2);
        for(int i=0;i<n;i++){
            if(d1[i]>=0 && d2[i]>=0){
                int max=Math.max(d1[i],d2[i]);
                if(max<check){
                    check=max;
                    res=i;
                }
            }
        }
        return res;
    }
    public void dfs(int curr,int d,int edges[],int dist[]){
        while(curr!=-1 && dist[curr]==-1){
            dist[curr]=d++;
            curr=edges[curr];
        }
    }
}