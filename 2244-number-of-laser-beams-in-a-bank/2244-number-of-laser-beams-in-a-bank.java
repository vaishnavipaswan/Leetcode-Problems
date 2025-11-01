class Solution {
    public int numberOfBeams(String[] bank) {
        int res=0;
        int prev=0;
        int n=bank[0].length();
        for(String r: bank){
            int dev=0;
            for(int i=0;i<n;i++){
                if(r.charAt(i)=='1'){
                    dev++;
                }
            }
            if(dev>0){
                res+=dev*prev;
                prev=dev;
            }
        }
        return res;
    }
}