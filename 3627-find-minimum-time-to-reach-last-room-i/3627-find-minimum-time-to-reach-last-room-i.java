import java.util.*;

public class Solution {
    private int n,m,ans=Integer.MAX_VALUE;
    private int[][] moveTime,bestTime,dir={{-1,0},{0,1},{1,0},{0,-1}};
    private boolean[][] visited;

    public int minTimeToReach(int[][] moveTime){
        this.moveTime=moveTime;
        n=moveTime.length;
        m=moveTime[0].length;
        visited=new boolean[n][m];
        bestTime=new int[n][m];
        for(int[] row:bestTime) Arrays.fill(row,Integer.MAX_VALUE);
        
        visited[0][0]=true;
        time(0,0,0);
        return ans;
    }

    private void time(int i,int j,int time){
        if(time>=bestTime[i][j]) return;
        bestTime[i][j]=time;

        if(i==n-1&&j==m-1){
            ans=Math.min(ans,time);
            return;
        }

        for(int[] d:dir){
            int x=i+d[0],y=j+d[1];
            if(x>=0&&x<n&&y>=0&&y<m&&!visited[x][y]){
                visited[x][y]=true;
                int wait=moveTime[x][y];
                int nextTime=wait>time?wait+1:time+1;
                if(i==0&&j==0&&wait<=time) nextTime=1+wait;
                time(x,y,nextTime);
                visited[x][y]=false;
            }
        }
    }
}