class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c: s.toCharArray()) {
           map.put(c,map.getOrDefault(c,0)+1);
        }
        int even=Integer.MAX_VALUE;
        int odd=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            int a=entry.getValue();
            if(a%2==0) even=Math.min(a,even);
            else odd=Math.max(a,odd);
        }
        return odd-even;
    }
}