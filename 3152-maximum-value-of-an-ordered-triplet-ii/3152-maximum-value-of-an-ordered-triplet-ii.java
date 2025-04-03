class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxtriplet=0,maxele=0,maxdiff=0;
        for(int num: nums){
            maxtriplet=Math.max(maxtriplet,maxdiff*num);
            maxdiff=Math.max(maxdiff,maxele-num);
            maxele=Math.max(maxele,num);
        }
        return maxtriplet;
    }
}