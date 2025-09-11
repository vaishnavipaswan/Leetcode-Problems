class Solution {
    public String sortVowels(String s) {
        List<Character> vowels=new ArrayList<>();
        StringBuilder res=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(isVowel(s.charAt(i))){
                vowels.add(s.charAt(i));
            }
        }
        Collections.sort(vowels);
        int j=0;
        for(int i=0;i<n;i++){
            if(isVowel(s.charAt(i))){
                res.append(vowels.get(j));
                j++;
            }
            else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
    public boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') return true;
        return false;
    }
}