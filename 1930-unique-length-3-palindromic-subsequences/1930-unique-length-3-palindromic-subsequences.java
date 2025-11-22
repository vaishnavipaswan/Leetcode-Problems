class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int res=0;
        int first[]=new int[26];
        int last[]=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            if(first[idx]==-1) first[idx]=i;
            last[idx]=i;
        }
        for(int i=0;i<26;i++){
            if(first[i]!=-1 && first[i]<last[i]){
                boolean seen[]=new boolean[26];
                for(int j=first[i]+1;j<last[i];j++){
                    int middle=s.charAt(j)-'a';
                    if(!seen[middle]){
                        seen[middle]=true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}