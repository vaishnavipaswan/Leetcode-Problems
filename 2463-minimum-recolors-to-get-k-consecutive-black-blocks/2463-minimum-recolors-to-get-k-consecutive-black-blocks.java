class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l=0;
        int white=0;
        int recolor=Integer.MAX_VALUE;
        for(int r=0;r<blocks.length();r++){
            if(blocks.charAt(r)=='W') white++;
            if(r-l+1==k){
                recolor=Math.min(recolor,white);
                if(blocks.charAt(l)=='W') white--;
                l++;
            }
        }
        return recolor;
    }
}