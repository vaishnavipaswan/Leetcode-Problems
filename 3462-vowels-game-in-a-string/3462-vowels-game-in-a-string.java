class Solution {
    public boolean doesAliceWin(String s) {
        int vowels=0;
        boolean res=true;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(isVowel(s.charAt(i))) vowels++;
        }
        if(vowels==0) res=false;
        else  if(vowels%2!=0) res=true;
        return res;
    }
    public boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }
}