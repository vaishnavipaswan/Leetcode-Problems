class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int [][] table=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    table[i][j]=table[i-1][j-1]+1;
                }
                else{
                    table[i][j]=Math.max(table[i-1][j],table[i][j-1]);
                }
            }
        }
        StringBuilder res=new StringBuilder();
        int i=m,j=n;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                res.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(table[i-1][j]>table[i][j-1]){
                res.append(str1.charAt(i-1));
                i--;
            }
            else{
                res.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            res.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            res.append(str2.charAt(j-1));
            j--;
        }
        return res.reverse().toString();
    }
}