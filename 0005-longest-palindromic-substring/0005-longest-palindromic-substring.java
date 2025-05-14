class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        char ch[]=s.toCharArray();
        int max[]=new int[3];
        for(int i=0;i<n;i++){
            check(ch,i,i,max);
            check(ch,i,i+1,max);
        }
        return s.substring(max[1],max[2]+1);
    }
    public void check(char c[],int l,int r,int max[]){
        while(l>=0 && r<c.length && c[l]==c[r]){
            l--;
            r++;
        }
        l++;
        r--;
        if(r-l+1>max[0]){
            max[0]=r-l+1;
            max[1]=l;
            max[2]=r;
        }
    }
}