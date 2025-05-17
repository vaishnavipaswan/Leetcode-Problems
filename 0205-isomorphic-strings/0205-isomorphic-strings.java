class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer>idxs=new HashMap<>();
        HashMap<Character,Integer>idxt=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!idxs.containsKey(s.charAt(i))) idxs.put(s.charAt(i),i);
            if(!idxt.containsKey(t.charAt(i))) idxt.put(t.charAt(i),i);
            if(!idxs.get(s.charAt(i)).equals(idxt.get(t.charAt(i)))) return false;
        }
        return true;
    }
}