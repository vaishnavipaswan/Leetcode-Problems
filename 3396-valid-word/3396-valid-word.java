class Solution {
    public boolean isValid(String word){
        if(word.length()<3) return false;
        boolean hasVowel=false,hasConsonant=false;
        for(char c:word.toCharArray()){
            if(!Character.isLetterOrDigit(c)) return false;
            if(Character.isLetter(c)){
                if(isVowel(c)) hasVowel=true;
                else hasConsonant=true;
            }
        }
        return hasVowel&&hasConsonant;
    }
    public boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}