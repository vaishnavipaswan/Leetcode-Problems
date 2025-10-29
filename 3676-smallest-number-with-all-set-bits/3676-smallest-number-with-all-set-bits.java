class Solution {
    public int smallestNumber(int n) {
        int i=n;
        while((i &(i+1))!=0){
            i++;
        }
        return i;
    }
}