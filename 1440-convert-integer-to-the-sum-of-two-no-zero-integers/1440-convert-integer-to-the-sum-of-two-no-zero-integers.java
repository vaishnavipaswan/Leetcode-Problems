class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n;i++){
            int a=n-i;
            if(isNoZero(a) && isNoZero(i)){
                return new int []{i,a};
            }
        }
        return new int []{};
    }
    public boolean isNoZero(int n){
        while(n>0){
            if(n%10==0) return false;
            n/=10;
        }
        return true;
    }
}