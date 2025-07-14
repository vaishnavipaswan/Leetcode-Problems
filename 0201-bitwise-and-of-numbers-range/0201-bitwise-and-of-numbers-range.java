class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count=0;
        while(right>left){
            right=right&(right-1);
        }
        return left & right;
    }
}