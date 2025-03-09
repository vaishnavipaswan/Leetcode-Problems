class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extended=new int[colors.length+k-1];
        int res=0,left=0,right=1;
        for(int i=0;i<colors.length;i++){
            extended[i]=colors[i];
        }
        for(int i=0;i<k-1;i++){
            extended[colors.length+i]=colors[i];
        }
        while(right<extended.length){
            if(extended[right]==extended[right-1]){
                left=right;
                right++;
               continue;

            }
            right++;
            if(right-left<k){
                continue;
            }
            res++;
            left++;
        }
        return res;
    }
}