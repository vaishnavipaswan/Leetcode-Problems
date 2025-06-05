class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder res=new StringBuilder();
        UnionFind u=new UnionFind(26);
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            u.union(c1-'a',c2-'a');
        }
        for(char c: baseStr.toCharArray()) res.append((char)(u.find(c-'a')+'a'));
        return res.toString();
    }  
    class UnionFind{
        int parent[];
        public UnionFind(int n){
            parent=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        public int find(int n){
            if(parent[n]==n) return n;
            return parent[n]=find(parent[n]);
        }
        public void union(int a,int b){
            int ar=find(a);
            int br=find(b);
            if(ar!=br){
                if(ar<br) parent[br]=ar;
                else parent[ar]=br;
            }
        }
    }
}