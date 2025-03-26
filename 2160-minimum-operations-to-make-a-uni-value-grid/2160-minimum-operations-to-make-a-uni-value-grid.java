class Solution {
    public int minOperations(int[][] grid, int x) {
     List<Integer> arr=new ArrayList<>();
     int rem=grid[0][0]%x;
     for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[i].length;j++){
            if(grid[i][j]%x != rem) return -1;
            arr.add(grid[i][j]);
        }
     }
     Collections.sort(arr);
     int steps=0;
     int mid=arr.get(arr.size()/2);
     for(int a:arr){
        steps+=Math.abs(a-mid)/x;
     }
     return steps;
    }
}