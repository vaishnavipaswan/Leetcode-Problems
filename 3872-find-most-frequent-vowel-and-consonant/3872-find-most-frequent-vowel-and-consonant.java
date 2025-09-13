class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> vowel=new HashMap<>();
        HashMap<Character,Integer> conso=new HashMap<>();
        for(char c: s.toCharArray()){
            if(isVowel(c)) vowel.put(c,vowel.getOrDefault(c,0)+1);
            else conso.put(c,conso.getOrDefault(c,0)+1);
        }
        int maxvowel=0,maxconso=0;
        for(int i:vowel.values()){
            maxvowel=Math.max(i,maxvowel);
        }
        for(int i:conso.values()){
            maxconso=Math.max(i,maxconso);
        }
        int res=maxvowel+maxconso;
        return res;
    }
    public boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }
}