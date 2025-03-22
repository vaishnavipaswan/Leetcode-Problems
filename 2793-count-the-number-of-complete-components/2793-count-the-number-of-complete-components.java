class Solution {
    List<List<Integer>> adj=new ArrayList<>();
    Set<Integer> visit=new HashSet<>();
    public int countCompleteComponents(int n, int[][] e) {
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int[] edge:e){
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            int res=0;
            for(int v=0;v<n;v++){
                if(visit.contains(v)){
                    continue;
                }
                List<Integer> comp=new ArrayList<>();
                dfs(v,comp);
                boolean isComplete=true;
                for(int ver:comp){
                    if(comp.size()-1!= adj.get(ver).size()){
                        isComplete=false;
                        break;
                    }
                }
                if(isComplete){
                    res++;
                }
            }
            return res;
    }
    public void dfs(int v,List<Integer> comp){
        if(visit.contains(v)) return;
        visit.add(v);
        comp.add(v);
        for(int n: adj.get(v)){
            dfs(n,comp);
        }
    }
}