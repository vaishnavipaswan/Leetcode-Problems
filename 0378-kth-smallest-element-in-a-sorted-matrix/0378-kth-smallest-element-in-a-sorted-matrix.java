class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>q=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                q.add(matrix[i][j]);
                if(q.size()>k) q.poll();
            }
        }
        return q.peek();
    }
}