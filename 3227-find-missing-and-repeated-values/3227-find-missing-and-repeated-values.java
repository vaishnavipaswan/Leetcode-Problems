class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int size=n*n;
        int count[]=new int[size+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                count[grid[i][j]]++;
            }
        }
        int a=-1,b=-1;
        for(int k=1;k<=size;k++){
            if(count[k]==2){
                a=k;
            }
            else if(count[k]==0){
                b=k;
            }
        }
        return new int[]{a,b};
    }
}