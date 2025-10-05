class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean p[][]=new boolean[m][n];
        boolean a[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            p[i][0]=true;
            a[i][n-1]=true;
        }
        for(int j=0;j<n;j++){
            p[0][j]=true;
            a[m-1][j]=true;
        }
        boolean updated=true;
        while(updated){
            updated=false;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!p[i][j]){
                        if(i>0 && p[i-1][j] && heights[i][j]>=heights[i-1][j]){
                            p[i][j]=true;
                            updated=true;
                        }
                        else if(i<m-1 && p[i+1][j] && heights[i][j]>=heights[i+1][j]){
                            p[i][j]=true;
                            updated=true;
                        }
                        else if(j>0 && p[i][j-1] && heights[i][j]>=heights[i][j-1]){
                            p[i][j]=true;
                            updated=true;
                        }
                        else if(j<n-1 && p[i][j+1] && heights[i][j]>=heights[i][j+1]){
                            p[i][j]=true;
                            updated=true;
                        }
                    }
                    if(!a[i][j]){
                        if(i>0 && a[i-1][j] && heights[i][j]>=heights[i-1][j]){
                            a[i][j]=true;
                            updated=true;
                        }
                        else if(i<m-1 && a[i+1][j] && heights[i][j]>=heights[i+1][j]){
                            a[i][j]=true;
                            updated=true;
                        }
                        else if(j>0 && a[i][j-1] && heights[i][j]>=heights[i][j-1]){
                            a[i][j]=true;
                            updated=true;
                        }
                        else if(j<n-1 && a[i][j+1] && heights[i][j]>=heights[i][j+1]){
                            a[i][j]=true;
                            updated=true;
                        }
                    }
                }
            }
        }
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p[i][j] && a[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
}