class Solution {
    public int maximumGain(String s, int x, int y) {
        int total=0;
            if(x>=y){
                StringBuilder sb=new StringBuilder();
                total+=remove(s,'a','b',x,sb);
                total+=remove(sb.toString(),'b','a',y,null);
            }
            else{
                StringBuilder sb=new StringBuilder();
                total+=remove(s,'b','a',y,sb);
                total+=remove(sb.toString(),'a','b',x,null);
            }
        return total;
    }
    public int remove(String s,char first,char second,int n,StringBuilder left){
        int total=0;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==first && c==second){
                sb.deleteCharAt(sb.length()-1);
                total+=n;
            }
            else {
                sb.append(c);
            }
        }
        if(left!=null) left.append(sb);
        return total;
    }
    public String swap(String s,char a,char b){
        StringBuilder res=new StringBuilder();
        for(char c: s.toCharArray()){
            if(c==a) res.append(b);
            else if(c==b) res.append(a);
            else res.append(c);
        }
        return res.toString();
    }
}