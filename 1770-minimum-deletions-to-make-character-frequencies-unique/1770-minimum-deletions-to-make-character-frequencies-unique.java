class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        int min=0;
        for(char i: s.toCharArray()) map.put(i,map.getOrDefault(i,0)+1);
            for(int f: map.values()){
                while(f>0 && set.contains(f)){
                    f--;
                    min++;
                }
                if(f>0) set.add(f);
            }
        return min;
    }
}