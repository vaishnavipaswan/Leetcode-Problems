class Solution {
    public int maximumCandies(int[] candies, long k) {
        if(candies==null || candies.length==0) return 0;
        int low=0;
        int high=findMax(candies);
        return binarySearch(candies,k,low,high);
    }
    public int binarySearch(int[] candies,long k,int low,int high){
        int result=-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(willDivide(candies,middle,k)){
                result=middle;
                low=middle+1;
            }
            else{
                high=middle-1;
            }
        }
            return result;
    }
        public boolean willDivide(int[] candies,int inHand,long k){
            if(inHand==0) return true;
            long total=0;
            for(int n:candies){
                total+=n/inHand;
                if(total>=k) return true;
            }
            return false;
        }
        public int findMax(int[] candies){
            int max=0;
            for(int n: candies){
                if(max<n) max=n;
            }
            return max;
        }
}