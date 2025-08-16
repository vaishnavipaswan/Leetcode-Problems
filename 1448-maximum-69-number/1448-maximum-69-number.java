class Solution {
    public int maximum69Number (int num) {
        int res=0;
        StringBuilder str=new StringBuilder(String.valueOf(num));
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='6'){
                str.setCharAt(i,'9');
                break;
            }
        }
        res=Integer.parseInt(str.toString());
        return res;
    }
}