class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        return numBottles+exchange(numBottles,numExchange);
    }
    public int exchange(int n,int k){
        if(n<k) return 0;
        return 1+exchange(n-k+1,k+1);
    }
}