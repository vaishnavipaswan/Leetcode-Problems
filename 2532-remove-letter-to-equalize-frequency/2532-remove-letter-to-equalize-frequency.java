class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char i: word.toCharArray()) map.put(i,map.getOrDefault(i,0)+1);
        for(char i: new HashSet<>(map.keySet())){
            map.put(i,map.get(i)-1);
            if(map.get(i)==0) map.remove(i);
            HashSet<Integer>unique=new HashSet<>(map.values());
            if(unique.size()==1) return true;
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return false;
    }
}