class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max=0;
        int area=0;
        int idx=0;
        for(int i=0;i<dimensions.length;i++){
            int l=dimensions[i][0];
            int b=dimensions[i][1];
            double dia=Math.sqrt(l*l+b*b);
            if(max<dia) {
                idx=i;
                max=dia;
            }
            else if(max==dia){
                int a1=dimensions[idx][0]*dimensions[idx][1];
                int a2=dimensions[i][0]*dimensions[i][1];
                idx=a1>a2?idx:i;
            }
        }
        area=dimensions[idx][0]*dimensions[idx][1];
        return area;
    }
}