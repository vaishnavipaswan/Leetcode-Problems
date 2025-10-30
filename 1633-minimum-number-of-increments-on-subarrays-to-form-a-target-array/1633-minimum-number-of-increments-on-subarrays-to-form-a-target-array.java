class Solution {
    public int minNumberOperations(int[] target) {
        int res=0;
        int prev=0;
        for(int i: target){
            if(i>prev){
                res+=i-prev;
            }
            prev=i;
        }
        return res;
    }
}