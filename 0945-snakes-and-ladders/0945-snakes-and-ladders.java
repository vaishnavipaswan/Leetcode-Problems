class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int min[]=new int[n*n+1];
        Arrays.fill(min,-1);
        Queue <Integer>q=new LinkedList<>();
        min[1]=0;
        q.offer(1);
        while(!q.isEmpty()){
           int x=q.poll();
           for(int i=1;i<=6 && i+x<=n*n;i++){
            int temp=x+i;
            int f,y;
            int r=(temp-1)/n;
            int c=(temp-1)%n;
            if(r%2==1) f=board[n-1-r][(n-1-c)];
            else f=board[n-1-r][c];
            if(f>0) y=f;
            else y=temp;
            if(y==n*n) return min[x]+1;
            if(min[y]==-1){
                min[y]=min[x]+1;
                q.offer(y);
            }
           } 
        }
        return -1;
    }
}