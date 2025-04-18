class Solution {
    public String countAndSay(int n) {
        String res="1";
        for(int i=1;i<n;i++){
        res=rle(res);
        }
        return res;
    }
    public String rle(String s){
        StringBuilder res=new StringBuilder();
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            } else{
                res.append(count).append(s.charAt(i-1));
                count=1;
            }
        }
        res.append(count).append(s.charAt(s.length()-1));
        return res.toString();
    }
}