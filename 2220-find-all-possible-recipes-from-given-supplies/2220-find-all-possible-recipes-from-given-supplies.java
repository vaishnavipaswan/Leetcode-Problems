class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,List<String>>graph=new HashMap<>();
        Map<String,Integer> indegree=new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            String recipe=recipes[i];
            List<String> ingredientList=ingredients.get(i);
            indegree.put(recipe,ingredientList.size());
            for(String ing:ingredientList){
                if(!graph.containsKey(ing)){
                    graph.put(ing,new ArrayList<>());
                }
                graph.get(ing).add(recipe);
            }
        }
        List<String> res=new ArrayList<>();
        Queue<String> queue=new LinkedList<>(Arrays.asList(supplies));
        Set<String>recipeset=new HashSet<>(Arrays.asList(recipes));
        while(!queue.isEmpty()){
            String supply=queue.poll();
            if(recipeset.contains(supply)){
                res.add(supply);
            }
            if(graph.containsKey(supply)){
                for(String r: graph.get(supply)){
                    indegree.put(r,indegree.get(r)-1);
                    if(indegree.get(r)==0) queue.offer(r);
                }
            }
        }
        return res;
    }
}