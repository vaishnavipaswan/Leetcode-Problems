class Solution {
    static class Node{
        Map<String,Node>children=new HashMap<>();
        String name="";
        boolean duplicate=false;
    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root=new Node();
        for(List<String> path: paths){
            Node curr=root;
            for(String folder:path){
                curr=curr.children.computeIfAbsent(folder,k->new Node());
                curr.name=folder;
            }
        }
        Map<String,List<Node>>map=new HashMap<>();
        serialize(root,map);
        for(var entry: map.entrySet()){
            if(entry.getValue().size()>1){
                for(Node node:entry.getValue()) node.duplicate=true;
            }
        }
        List<List<String>> res=new ArrayList<>();
        dfs(root,new ArrayList<>(),res);
        return res;
    }
    public static String serialize(Node node,Map<String,List<Node>>map){
        if(node.children.isEmpty()) return "";
        List<String>serials=new ArrayList<>();
        for(String key: new TreeSet<>(node.children.keySet())){
            serials.add(key+ "(" +serialize(node.children.get(key),map)+ ")");
        }
        String serial=String.join("",serials);
        map.computeIfAbsent(serial,k->new ArrayList<>()).add(node);
        return serial;
    }
    public static void dfs(Node node,List<String> path,List<List<String>> res){
        for(Node child:node.children.values()){
            if(!child.duplicate){
                path.add(child.name);
                res.add(new ArrayList<>(path));
                dfs(child,path,res);
                path.remove(path.size()-1);
            }
        }
    }
}