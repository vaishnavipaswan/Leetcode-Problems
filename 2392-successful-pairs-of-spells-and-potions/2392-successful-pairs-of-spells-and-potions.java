class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int idx=binarySearch(potions,spells[i],success);
            if(idx!=-1) res[i]=potions.length-idx;
        }
        return res;
    }
    int binarySearch(int potions[],long strength,long success){
        int low=0;
        int high=potions.length-1;
        int idx=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((long)potions[mid]*strength>=success){
                idx=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return idx;
    }
}