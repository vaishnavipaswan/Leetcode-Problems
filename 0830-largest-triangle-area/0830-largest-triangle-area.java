class Solution {
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    res=Math.max(res,area(points[i],points[j],points[k]));
                }
            }
        }
        return res;
    }
    public double area(int p[],int q[],int r[]){
        return 0.5*Math.abs(p[0]*(q[1]-r[1])+q[0]*(r[1]-p[1])+r[0]*(p[1]-q[1]));
    }
}