class Solution {
    public int longestSubsequence(String s, int k) {
        int count=0;
        int sum=0;
        int bits=(int)(Math.log(k)/Math.log(2))+1;
        StringBuilder str=new StringBuilder(s);
        int i=0;
        for(char c: str.reverse().toString().toCharArray()){
            if(c=='1'){
                if(i<bits && sum+(1<<i)<=k){
                    sum+=1<<i;
                    count++;
                }
            }
            else count++;
            i++;
        }
        return count;
    }
}