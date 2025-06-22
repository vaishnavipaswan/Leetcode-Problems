class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<s.length();i++){
            temp.append(s.charAt(i));
            if(temp.length()==k){
                res.add(temp.toString());
                temp.setLength(0);
            }
        }
        if(temp.length()!=0){
            while(temp.length()<k) temp.append(fill);
            res.add(temp.toString());
        }
        return res.toArray(new String[0]);
    }
}