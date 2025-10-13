class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<Map<Character,Integer>>freq=new ArrayList<>();
        for(String s: words){
            Map<Character,Integer> check=new HashMap<>();
            for(char c: s.toCharArray()){
                check.put(c,check.getOrDefault(c,0)+1);
            }
            freq.add(check);
        }
        List<String> res=new ArrayList<>();
        res.add(words[0]);
        for(int i=1;i<n;i++){
            if(!freq.get(i).equals(freq.get(i-1))){
                res.add(words[i]);
            }
        }
        return res;
    }
}
