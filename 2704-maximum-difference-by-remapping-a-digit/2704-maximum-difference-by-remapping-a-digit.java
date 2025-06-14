class Solution {
    public int minMaxDifference(int num) {
        String s=Integer.toString(num);
        StringBuilder s1=new StringBuilder(s);
        StringBuilder s2=new StringBuilder(s);
        char n1=' ';
        for(char i: s.toCharArray()) {
            if(i!='9') {
                 n1=i;
                break;
            }
        }
        if(n1!=' '){
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==n1) s1.setCharAt(i,'9');
        }
        }
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)==s.charAt(0)) s2.setCharAt(i,'0');
        }

       int max=Integer.parseInt(s1.toString());
       int min=Integer.parseInt(s2.toString());
        return max-min;
    }
}