class Solution {
    public int maxDistance(String s, int k) {
        if(k==s.length()) return k;
        int nw=dist('N','W',s,k);
        int ne=dist('N','E',s,k);
        int sw=dist('S','W',s,k);
        int se=dist('S','E',s,k);
        int res=Math.max(Math.max(ne,nw),Math.max(sw,se));
        return res;
    }
    public int dist(char a,char b, String s,int k){
        int d=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==a || c==b){
                d++;
            }
            else{
            if(k>0){
                k--;
                d++;
            }
            else{
                max=Math.max(d,max);
                d--;
            }
            }
        }
        max=Math.max(max,d);
        return max;
    }
}