class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
        StringBuilder t=new StringBuilder();
        for(int i=1;i<s.length();i++){
            int sum=(s.charAt(i)-'0')+(s.charAt(i-1)-'0');
            t.append(sum%10);
        }
        s=t.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}