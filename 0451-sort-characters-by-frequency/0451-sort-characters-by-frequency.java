class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        for(char c: s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character>q=new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
        q.addAll(freq.keySet());
        StringBuilder res=new StringBuilder();
        while(!q.isEmpty()){
            char c=q.poll();
            res.append(String.valueOf(c).repeat(freq.get(c)));
        }
        return res.toString();
    }
}