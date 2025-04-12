class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int start=0;
        int last=s.length()-1;
        while(start<=last){
            char first=s.charAt(start);
            char end=s.charAt(last);
            if(!Character.isLetterOrDigit(first)) start++;
            else if(!Character.isLetterOrDigit(end)) last--;
            else{
                if(Character.toLowerCase(first)!=Character.toLowerCase(end))return false;
                start++;
                last--;
            }
        }
        return true;
    }
}