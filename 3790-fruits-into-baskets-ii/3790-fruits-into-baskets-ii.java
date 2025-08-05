class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res=fruits.length;
        for(int i=0;i<fruits.length;i++){
            for(int j=0;j<baskets.length;j++){
                if(fruits[i]<=baskets[j]){
                    res--;
                    baskets[j]=0;
                    break;
                }
            }
        }
        return res;
    }
}