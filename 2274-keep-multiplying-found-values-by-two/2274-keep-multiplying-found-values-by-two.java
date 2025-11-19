class Solution {
    public int findFinalValue(int[] nums, int original) {
        int bits=0;
        for(int n: nums){
            if(n% original !=0) continue;
            int l=n/original;
            if((l &(l-1))==0) bits|=l;
        }
        bits++;
        return original*(bits & -bits);
    }
}