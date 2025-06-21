class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(char c: word.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i: map.values()) list.add(i);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            int y=list.get(i);
            int del=0;
            for(int j=0;j<i;j++){
                del+=list.get(j);
            }
            for(int j=i+1;j<list.size();j++){
                if(list.get(j)>y+k){
                    del+=list.get(j)-(y+k);
                }
            }
            min=Math.min(del,min);
        }
        return min;
    }
}