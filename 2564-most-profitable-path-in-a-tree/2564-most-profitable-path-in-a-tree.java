class Solution {
    List<Integer> b2a=new ArrayList<>();
    int maxsum=Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        Map<Integer,Set<Integer>> g=new HashMap<>();
        for(int i=0;i<n;i++) g.put(i,new HashSet<>());
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            g.get(v).add(u);
            g.get(u).add(v);
        }
        dfs(bob,0,g,new ArrayList<Integer>(){{add(bob);}},new HashSet<Integer>(){{add(bob);}});
        for(int i =0;i<b2a.size()/2;i++){
            amount[b2a.get(i)]=0;
        }
        if(b2a.size()%2!=0){
            int m=b2a.get(b2a.size()/2);
            amount[m]/=2;
        }
        Set<Integer> visited=new HashSet<>();
        visited.add(0);
        maxPathSum(0,g,amount,visited,amount[0]);
        return maxsum;
        
    }
private boolean dfs(int root,int target,Map<Integer,Set<Integer>> graph,List<Integer>currPath,Set<Integer>visited){
    if(root==target){
        b2a=new ArrayList<>(currPath);
        return true;
    }
    for(int n:graph.get(root)){
        if(visited.contains(n)) continue;
        visited.add(n);
        currPath.add(n);
        if(dfs(n,target,graph,currPath,visited)) return true;
        currPath.remove(currPath.size()-1);
        visited.remove(n);
    }
    return false;
    }
private void maxPathSum(int root,Map<Integer,Set<Integer>>graph,int[]amt,Set<Integer> visited,int currSum){
    int count=0;
    for(int c: graph.get(root)){
        if(visited.contains(c))continue;

        visited.add(c);
        maxPathSum(c,graph,amt,visited,currSum+amt[c]);
        visited.remove(c);
        count++;
    }
    if (count==0) maxsum=Math.max(maxsum,currSum);
    return;
}
}