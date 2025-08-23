class Solution {
    static int[] A=new int[30],T=new int[30];
    public int minimumSum(int[][] grid){
        int n=grid.length,m=grid[0].length;
        buildAT(grid,n,m);
        int ans=Integer.MAX_VALUE;
        for(int c1=0;c1<m-2;c1++)
            for(int c2=c1+1;c2<m-1;c2++){
                int a=minRect(0,n-1,0,c1);
                int b=minRect(0,n-1,c1+1,c2);
                int c=minRect(0,n-1,c2+1,m-1);
                ans=Math.min(ans,a+b+c);
            }

        for(int r1=0;r1<n-2;r1++)
            for(int r2=r1+1;r2<n-1;r2++){
                int a=minRect(0,r1,0,m-1);
                int b=minRect(r1+1,r2,0,m-1);
                int c=minRect(r2+1,n-1,0,m-1);
                ans=Math.min(ans,a+b+c);
            }

        for(int r=0;r<n-1;r++)
            for(int c=0;c<m-1;c++){
                int top=minRect(0,r,0,m-1);
                int bl=minRect(r+1,n-1,0,c);
                int br=minRect(r+1,n-1,c+1,m-1);
                ans=Math.min(ans,top+bl+br);

                int bottom=minRect(r+1,n-1,0,m-1);
                int tl=minRect(0,r,0,c);
                int tr=minRect(0,r,c+1,m-1);
                ans=Math.min(ans,bottom+tl+tr);

                int left=minRect(0,n-1,0,c);
                tr=minRect(0,r,c+1,m-1);
                br=minRect(r+1,n-1,c+1,m-1);
                ans=Math.min(ans,left+tr+br);

                int right=minRect(0,n-1,c+1,m-1);
                tl=minRect(0,r,0,c);
                bl=minRect(r+1,n-1,0,c);
                ans=Math.min(ans,right+tl+bl);
            }

        return ans;
    }
    static void buildAT(int[][] grid,int n,int m){
        for(int i=0;i<n;i++)A[i]=0;
        for(int j=0;j<m;j++)T[j]=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1){
                    A[i]|=(1<<j);
                    T[j]|=(1<<i);
                }
    }
        static int minRect(int i0,int iN,int j0,int jN){
        int iMin=30,iMax=-1,jMin=30,jMax=-1;
        for(int i=i0;i<=iN;i++){
            int row=A[i],mRow=(row>>j0)<<j0;
            mRow&=((1<<(jN+1))-1);
            if(mRow>0){iMin=i;break;}
        }
        if(iMin==30)return 100000000;
        for(int i=iN;i>=iMin;i--){
            int row=A[i],mRow=(row>>j0)<<j0;
            mRow&=((1<<(jN+1))-1);
            if(mRow>0){iMax=i;break;}
        }
        for(int j=j0;j<=jN;j++){
            int col=T[j],mCol=(col>>i0)<<i0;
            mCol&=((1<<(iN+1))-1);
            if(mCol>0){jMin=j;break;}
        }
        for(int j=jN;j>=jMin;j--){
            int col=T[j],mCol=(col>>i0)<<i0;
            mCol&=((1<<(iN+1))-1);
            if(mCol>0){jMax=j;break;}
        }
        return (iMax-iMin+1)*(jMax-jMin+1);
    }
}