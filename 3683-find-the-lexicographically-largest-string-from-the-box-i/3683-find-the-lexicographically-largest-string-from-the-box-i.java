class Solution {
    public String answerString(String word, int numFriends) {
        String res="";
        int j=1;
        if(numFriends==1) return word;
        for(int i=0;i<word.length();i++){
            String sub=word.substring(i,Math.min(i+word.length()-numFriends+1,word.length()));
            if(res.compareTo(sub)<=0) res=sub;
        }
        return res;
    }
}