class Solution {
    public String multiply(String num1, String num2) {
    if(num1.equals("0") || num2.equals("0") || num1.length()==0 || num2.length()==0) return "0";
    if("1".equals(num1)) return num2;
    if("1".equals(num2)) return num1;
    int res[]=new int[num1.length()+num2.length()]; 
    for(int i=num1.length()-1;i>=0;i--){
        for(int j=num2.length()-1;j>=0;j--){
            int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            mul+=res[i+j+1];
            res[i+j+1]=mul%10;
            res[i+j]+=mul/10;
        }
    }
    StringBuilder s=new StringBuilder();
    for(int r: res){
        if(s.length()==0 && r==0) continue;
        s.append(r);
    }
    return s.toString();
    }
}