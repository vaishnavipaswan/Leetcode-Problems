class Solution {
    public int numSub(String s) {
        int count=0;
        int total=0;
        int mod=1000000007;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') count++;
            else count=0;
            total=(total+count)%mod;
        }
        return (int)total;
    }
}