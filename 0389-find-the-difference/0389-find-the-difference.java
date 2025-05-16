class Solution {
    public char findTheDifference(String s, String t) {
        int res=0;
        String str =s+t;
        for(char c: str.toCharArray()) res^=(int)c;
        return (char)res;
    }
}